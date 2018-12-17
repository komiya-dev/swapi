package com.yurentsy.swapi.mvp.view

import com.yurentsy.swapi.mvp.model.entity.ListData

interface IListView<T : ListData> {
    fun showProgressBar()
    fun hideProgressBar()
    fun showData(data: MutableList<T>)
    fun showToast(text: String)
    fun hideSwipe()
}