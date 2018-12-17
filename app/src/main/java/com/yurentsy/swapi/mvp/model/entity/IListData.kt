package com.yurentsy.swapi.mvp.model.entity

interface IListData {
    val name: String
    val url: String
    val displayData: Map<String, String>?
}