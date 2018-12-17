package com.yurentsy.swapi.mvp.model.entity

open class Result<M : ListData>(
    val count: Int,
    val results: MutableList<M>
)