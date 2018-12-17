package com.yurentsy.swapi.mvp.view

import com.yurentsy.swapi.mvp.model.entity.Film

interface ListView {
    fun showProgressBar()
    fun hideProgressBar()
    fun showData(data: MutableList<Film>)
    fun showToast(text: String)
    fun hideSwipe()
}