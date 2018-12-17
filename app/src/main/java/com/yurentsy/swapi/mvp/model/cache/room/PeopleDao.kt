package com.yurentsy.swapi.mvp.model.cache.room

import android.arch.persistence.room.*
import com.yurentsy.swapi.mvp.model.entity.People

@Dao
interface PeopleDao {
    @Query("SELECT * FROM people")
    fun getAll(): MutableList<People>

    @Query("SELECT * FROM people WHERE name LIKE :search")
    fun getSearch(search: String): MutableList<People>

    @Query("SELECT * FROM people WHERE isFavorite = :isFavorite")
    fun getAllFavorite(isFavorite: Boolean): MutableList<People>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(person: People)

    @Update()
    fun update(person: People)

    @Delete
    fun delete(person: People)
}