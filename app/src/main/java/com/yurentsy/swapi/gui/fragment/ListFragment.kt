package com.yurentsy.swapi.gui.fragment

import android.os.Bundle
import android.os.Parcelable
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import com.yurentsy.swapi.App
import com.yurentsy.swapi.R
import com.yurentsy.swapi.gui.Listener
import com.yurentsy.swapi.gui.adapter.list.ListAdapter
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class ListFragment : Fragment(),
    Listener,
    BottomNavigationView.OnNavigationItemReselectedListener {

    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }

    @Inject
    lateinit var listAdapter: ListAdapter

    private var recyclerViewState: Parcelable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.getInstance().initModelComponent(this).inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = listAdapter
        bottom_navigation.setOnNavigationItemReselectedListener(this)
    }

    override fun onResume() {
        super.onResume()
        recyclerViewState?.let { state ->
            recycler.layoutManager.onRestoreInstanceState(state)
        }
    }

    override fun onPause() {
        super.onPause()
        recyclerViewState = recycler.layoutManager.onSaveInstanceState()
    }

    override fun onViewHolderClick(position: Int) {
//        val model = modelList[position]
//        Toast.makeText(
//            context,
//            model.state.plus(", ").plus(model.city),
//            Toast.LENGTH_SHORT
//        )
//            .show()
    }

    override fun onViewChickenBoxClick(position: Int, b: Boolean) {

    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {


        //return true
    }

    override fun onNavigationItemReselected(item: MenuItem) {
        when (item.itemId) {
            R.id.navigation_home -> {

            }
            R.id.navigation_bookmarks -> {

            }
            else -> {

            }
        }
    }
}