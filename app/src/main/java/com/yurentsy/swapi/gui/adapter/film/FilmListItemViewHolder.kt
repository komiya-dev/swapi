package com.yurentsy.swapi.gui.adapter.film

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.CompoundButton
import com.yurentsy.swapi.gui.Listener
import com.yurentsy.swapi.mvp.model.entity.Film
import kotlinx.android.synthetic.main.item_film.view.*

class FilmListItemViewHolder(
    val view: View,
    val listener: Listener
) : RecyclerView.ViewHolder(view),
    View.OnClickListener,
    CompoundButton.OnCheckedChangeListener {

    val context = view.context

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(film: Film) {
        view.title.text = film.title
        view.episode_id.text = film.episodeId.toString()
        view.opening_crawl.text = film.openingCrawl
        view.director.text = film.director
        view.producer.text = film.producer
        view.release_date.text = film.releaseDate

        view.is_favorite.isChecked = film.isFavorite
        view.is_favorite.setOnCheckedChangeListener(this) /*{ _, b ->
            film.isFavorite = b
        }*/
    }

    override fun onClick(v: View?) {
        val position = adapterPosition
        if (position != RecyclerView.NO_POSITION)
            listener.onViewHolderClick(position)
    }

    override fun onCheckedChanged(button: CompoundButton?, b: Boolean) {
        val position = adapterPosition
        if (position != RecyclerView.NO_POSITION)
            listener.onViewChickenBoxClick(position, b)
    }
}