package com.yurentsy.swapi.gui.adapter.film

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.yurentsy.swapi.mvp.model.entity.Film

class FilmAdapter(
    val factory: FilmListItemViewHolderFactory
) : RecyclerView.Adapter<FilmListItemViewHolder>() {

    var result: MutableList<Film> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmListItemViewHolder =
        factory.createViewHolder(parent)

    override fun onBindViewHolder(holder: FilmListItemViewHolder, position: Int) =
        holder.bind(result[position])

    override fun getItemCount(): Int =
        result.size
}