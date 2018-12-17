package com.yurentsy.swapi.mvp.presenter

import com.yurentsy.swapi.mvp.model.entity.People
import com.yurentsy.swapi.mvp.model.repo.Repo
import com.yurentsy.swapi.mvp.view.IListView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PeoplePresenter(val view: IListView<People>, val repo: Repo) : ListPresenter<People> {
    lateinit var data: MutableList<People>

    override fun getDataIsFavorite(search: String?) {
        loadWithFilter(search) { d -> d.isFavorite }
    }

    override fun getDataByTitleSearch(search: String) {
        load(search)
    }

    override fun updateFlagIsFavorite(list: MutableList<People>, position: Int, b: Boolean) {
        updateFlag(list[position], b)
    }

    private fun updateFlag(person: People, b: Boolean) {
        person.isFavorite = b
        repo.setPerson(person)
    }

    override fun load(search: String?) {
        repo.getPeopleBySearch(search)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                view.showProgressBar()
            }
            .subscribe({ res ->
                data = res.results
                view.showData(res.results)
                view.hideProgressBar()
                view.hideSwipe()
            }, {
                view.showToast("Error load")
            })
    }

    fun loadWithFilter(search: String?, filter: (People) -> Boolean) {
        repo.getPeopleBySearchFromCache(search)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                view.showProgressBar()
            }
            .subscribe({ res ->
                view.showData(res.results.filter(filter).toMutableList())
                view.hideProgressBar()
                view.hideSwipe()
            }, {
                view.showToast("Error load")
            })
    }

    override fun loadFromCache(search: String?) {
        repo.getPeopleBySearchFromCache(search)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                view.showProgressBar()
            }
            .subscribe({ res ->
                view.showData(res.results)
                view.hideProgressBar()
                view.hideSwipe()
            }, {
                view.showToast("Error load")
            })
    }

    override fun saveDataWasChanged(data: MutableList<People>) {
        repo.setPeopleHasWasChanged(data)
    }
}