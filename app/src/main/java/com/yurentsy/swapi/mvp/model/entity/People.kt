package com.yurentsy.swapi.mvp.model.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose

@Entity(tableName = "people", indices = [Index("name")])
data class People(
    @PrimaryKey
    val name: String,
    val birthYear: String,
    val eyeColor: String,
    val gender: String,
    val hairColor: String,
    val height: String,
    val mass: String,
    val skinColor: String,
    @Expose var isFavorite: Boolean
) : ListData {

    @Ignore
    var isExpanded: Boolean = false

    override val displayData: Map<String, String>?
        get() = mapOf(
            "Title" to name,
            "Birth year" to birthYear,
            "Eye color" to eyeColor,
            "Gender" to gender,
            "Height" to height,
            "Mass" to mass,
            "Skin color" to skinColor
        )
}