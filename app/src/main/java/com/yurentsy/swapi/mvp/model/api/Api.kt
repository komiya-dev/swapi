package com.yurentsy.swapi.mvp.model.api

import com.yurentsy.swapi.mvp.model.entity.Film
import com.yurentsy.swapi.mvp.model.entity.People
import com.yurentsy.swapi.mvp.model.entity.Result
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("films/")
    fun films(): Observable<Result<Film>>

    @GET("films/")
    fun films(@Query("page") page: Int? = null): Observable<Result<Film>>

    @GET("films/{id}/")
    fun film(@Path("id") filmdId: Int): Observable<Film>

    @GET("films/")
    fun searchFilms(@Query("search") search: String? = null): Observable<Result<Film>>


    @GET("people/") //[1..9]
    fun people(@Query("page") page: Int? = null): Observable<Result<People>>

    @GET("people/")
    fun searchPeople(@Query("search") search: String? = null): Observable<Result<People>>
}