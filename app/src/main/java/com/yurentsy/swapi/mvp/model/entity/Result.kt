package com.yurentsy.swapi.mvp.model.entity

open class Result<M : IListData>(
    val count: Int,
    val results: MutableList<M>
)