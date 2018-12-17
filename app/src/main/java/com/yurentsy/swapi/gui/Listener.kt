package com.yurentsy.swapi.gui

interface Listener {
    fun onViewHolderClick(position: Int)
    fun onViewChickenBoxClick(position: Int, b: Boolean)
}