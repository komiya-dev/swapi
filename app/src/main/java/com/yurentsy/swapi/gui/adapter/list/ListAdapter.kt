package com.yurentsy.swapi.gui.adapter.list

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.yurentsy.swapi.mvp.model.Model

class ListAdapter(
    val factory: ListItemViewHolderFactory,
    val models: List<Model>
) : RecyclerView.Adapter<ListItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder =
        factory.createViewHolder(parent)

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) =
        holder.bind(models[position])

    override fun getItemCount(): Int =
        models.size
}