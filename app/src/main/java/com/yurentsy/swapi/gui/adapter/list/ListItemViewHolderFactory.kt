package com.yurentsy.swapi.gui.adapter.list

import android.view.LayoutInflater
import android.view.ViewGroup
import com.yurentsy.swapi.R
import com.yurentsy.swapi.gui.Listener

class ListItemViewHolderFactory(val layoutInflater: LayoutInflater, val listener: Listener) {
    fun createViewHolder(parent: ViewGroup): ListItemViewHolder {
        val view = layoutInflater.inflate(R.layout.item_model, parent, false)
        return ListItemViewHolder(view, listener)
    }
}