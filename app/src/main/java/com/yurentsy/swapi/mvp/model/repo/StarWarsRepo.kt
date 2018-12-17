package com.yurentsy.swapi.mvp.model.repo

import com.yurentsy.swapi.mvp.model.api.Api
import com.yurentsy.swapi.mvp.model.cache.Cache
import com.yurentsy.swapi.mvp.model.entity.Film
import com.yurentsy.swapi.mvp.model.entity.Result
import com.yurentsy.swapi.utils.NetworkStatus
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class StarWarsRepo(val api: Api, val cache: Cache) : Repo {
    override fun getFilmsByPage(page: Int?): Observable<Result<Film>> {
        if (NetworkStatus.isOnline()) {
            val result = api.films(page)
            cache.updateAllFilms(result)
        }
        return cache.getAllFilms()
    }

    override fun getFilmsBySearch(search: String?): Observable<Result<Film>> {
        if (NetworkStatus.isOnline()) {
            search?.let {
                return getFilmsBySearchFromCache(search)
            }
            val result = api.films()
            cache.putAllFilms(result)
        }
        return getFilmsBySearchFromCache(search)
    }

    override fun getFilmsBySearchFromCache(search: String?): Observable<Result<Film>> =
        cache.getAllFilmsSearch(search)

    override fun setFilmsHasWasChanged(films: MutableList<Film>) {
        cache.updateAllFilms(
            Observable.just(Result(films.size, films))
                .observeOn(Schedulers.io())
        )
    }

    override fun setFilm(film: Film) {
        cache.putFilm(
            Observable.just(film)
                .observeOn(Schedulers.io())
        )
    }
}