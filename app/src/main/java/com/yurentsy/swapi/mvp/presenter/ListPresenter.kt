package com.yurentsy.swapi.mvp.presenter

import com.yurentsy.swapi.mvp.model.entity.ListData

interface ListPresenter<T : ListData> {
    fun getDataIsFavorite()
    fun getDataByTitleSearch(search: String)
    fun updateFlagIsFavorite(list: MutableList<T>, position: Int, b: Boolean)
    fun load(search: String? = null)
    fun loadFromCache(search: String? = null)
    fun saveDataWasChanged(data: MutableList<T>)
}