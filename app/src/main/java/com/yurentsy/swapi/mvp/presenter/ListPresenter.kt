package com.yurentsy.swapi.mvp.presenter

import com.yurentsy.swapi.mvp.model.entity.Film

interface ListPresenter {
    fun getDataIsFavorite()
    fun getDataByTitleSearch(search: String)
    fun updateFlagIsFavorite(list: MutableList<Film>, position: Int, b: Boolean)
    fun load(search: String? = null)
    fun loadFromCache(search: String? = null)
}