package com.yurentsy.swapi.gui.adapter.people

import android.view.LayoutInflater
import android.view.ViewGroup
import com.yurentsy.swapi.R
import com.yurentsy.swapi.gui.Listener

class PeopleListItemViewHolderFactory(val layoutInflater: LayoutInflater, val listener: Listener) {
    fun createViewHolder(parent: ViewGroup): PeopleListItemViewHolder {
        val view = layoutInflater.inflate(R.layout.item_people, parent, false)
        return PeopleListItemViewHolder(view, listener)
    }
}