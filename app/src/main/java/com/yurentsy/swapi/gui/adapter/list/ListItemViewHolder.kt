package com.yurentsy.swapi.gui.adapter.list

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import com.yurentsy.swapi.gui.Listener
import com.yurentsy.swapi.mvp.model.Model
import kotlinx.android.synthetic.main.item_model.view.*

class ListItemViewHolder(
    val view: View,
    val listener: Listener
) : RecyclerView.ViewHolder(view),
    View.OnClickListener {

    val context = view.context

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(model: Model) {
        view.colored_line.setBackgroundColor(ContextCompat.getColor(context, model.color))
        view.state.text = model.state
        view.city.text = model.city
    }

    override fun onClick(v: View?) {
        val position = adapterPosition
        if (position != RecyclerView.NO_POSITION)
            listener.onViewHolderClick(position)
    }
}