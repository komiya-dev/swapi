package com.yurentsy.swapi.mvp.model.cache

import com.yurentsy.swapi.mvp.model.entity.Film
import com.yurentsy.swapi.mvp.model.entity.People
import com.yurentsy.swapi.mvp.model.entity.Result
import io.reactivex.Observable

interface Cache {
    fun getAllFilms(): Observable<Result<Film>>
    fun getAllFilmsSearch(title: String?): Observable<Result<Film>>
    fun getAllFilmsFavorite(): Observable<Result<Film>>
    fun putAllFilms(films: Observable<Result<Film>>)
    fun putFilm(film: Observable<Film>)
    fun updateAllFilms(films: Observable<Result<Film>>)

    fun getAllPeople(): Observable<Result<People>>
    fun getAllPeopleSearch(name: String?): Observable<Result<People>>
    fun getAllPeopleFavorite(): Observable<Result<People>>
    fun putAllPeople(people: Observable<Result<People>>)
    fun putPerson(person: Observable<People>)
    fun updateAllPeople(people: Observable<Result<People>>)
}