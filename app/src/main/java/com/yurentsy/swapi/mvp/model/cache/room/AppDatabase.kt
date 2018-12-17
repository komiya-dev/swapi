package com.yurentsy.swapi.mvp.model.cache.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.yurentsy.swapi.mvp.model.entity.Film

@Database(entities = [Film::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
}