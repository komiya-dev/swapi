package com.yurentsy.swapi.gui.adapter.people

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.CompoundButton
import com.yurentsy.swapi.gui.Listener
import com.yurentsy.swapi.mvp.model.entity.People
import kotlinx.android.synthetic.main.item_people.view.*

class PeopleListItemViewHolder(
    val view: View,
    val listener: Listener
) : RecyclerView.ViewHolder(view),
    View.OnClickListener,
    CompoundButton.OnCheckedChangeListener {

    val context = view.context

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(people: People) {
        view.name.text = people.name
        view.birth_year.text = people.birthYear
        view.eye_color.text = people.eyeColor
        view.gender.text = people.gender
        view.p_height.text = people.height
        view.mass.text = people.mass
        view.skin_color.text = people.skinColor

        val expanded = people.isExpanded
        (view.people_sub_item as View).visibility = if (expanded) View.VISIBLE else View.GONE

        view.is_favorite.isChecked = people.isFavorite
        view.is_favorite.setOnCheckedChangeListener(this)
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