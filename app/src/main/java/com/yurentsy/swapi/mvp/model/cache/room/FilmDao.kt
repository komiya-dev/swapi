package com.yurentsy.swapi.mvp.model.cache.room

import android.arch.persistence.room.*
import com.yurentsy.swapi.mvp.model.entity.Film

@Dao
interface FilmDao {
    @Query("SELECT * FROM film")
    fun getAll(): MutableList<Film>

    @Query("SELECT * FROM film WHERE title LIKE :search")
    fun getSearch(search: String): MutableList<Film>

    @Query("SELECT * FROM film WHERE isFavorite = :isFavorite")
    fun getAllFavorite(isFavorite: Boolean): MutableList<Film>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(film: Film)

    @Update()
    fun update(film: Film)

    @Delete
    fun delete(film: Film)
}