package com.yurentsy.swapi.gui.adapter.film

import android.view.LayoutInflater
import android.view.ViewGroup
import com.yurentsy.swapi.R
import com.yurentsy.swapi.gui.Listener

class FilmListItemViewHolderFactory(val layoutInflater: LayoutInflater, val listener: Listener) {
    fun createViewHolder(parent: ViewGroup): FilmListItemViewHolder {
        val view = layoutInflater.inflate(R.layout.item_film, parent, false)
        return FilmListItemViewHolder(view, listener)
    }
}