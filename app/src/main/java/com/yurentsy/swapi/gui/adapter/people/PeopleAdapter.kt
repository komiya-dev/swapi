package com.yurentsy.swapi.gui.adapter.people

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.yurentsy.swapi.mvp.model.entity.People

class PeopleAdapter(
    val factory: PeopleListItemViewHolderFactory
) : RecyclerView.Adapter<PeopleListItemViewHolder>() {

    var result: MutableList<People> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleListItemViewHolder =
        factory.createViewHolder(parent)

    override fun onBindViewHolder(holder: PeopleListItemViewHolder, position: Int) =
        holder.bind(result[position])

    override fun getItemCount(): Int =
        result.size
}