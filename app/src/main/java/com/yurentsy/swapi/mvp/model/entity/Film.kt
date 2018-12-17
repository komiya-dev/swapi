package com.yurentsy.swapi.mvp.model.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose

@Entity(tableName = "film", indices = [Index("title")])
data class Film(
    val title: String,
    @PrimaryKey(autoGenerate = true)
    val episodeId: Int,
    val openingCrawl: String,
    val director: String,
    val producer: String,
    val releaseDate: String,
    @Expose var isFavorite: Boolean
) : ListData {

    @Ignore
    var isExpanded: Boolean = false

    override val displayData: Map<String, String>?
        get() = mapOf(
            "Title" to title,
            "Episode ID" to episodeId.toString(),
            "Opening Crawl" to openingCrawl,
            "Director" to director,
            "Producer" to producer,
            "Release date" to releaseDate
        )
}