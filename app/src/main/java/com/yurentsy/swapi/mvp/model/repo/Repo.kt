package com.yurentsy.swapi.mvp.model.repo

import com.yurentsy.swapi.mvp.model.entity.Film
import com.yurentsy.swapi.mvp.model.entity.Result
import io.reactivex.Observable

interface Repo {
    fun getFilmsByPage(page: Int? = null): Observable<Result<Film>>
    fun getFilmsBySearch(search: String? = null): Observable<Result<Film>>
    fun getFilmsBySearchFromCache(search: String? = null): Observable<Result<Film>>
    fun setFilmsHasWasChanged(films: MutableList<Film>)
    fun setFilm(film: Film)
}