package com.yurentsy.swapi.gui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yurentsy.swapi.App
import com.yurentsy.swapi.R
import com.yurentsy.swapi.utils.Constants
import com.yurentsy.swapi.utils.SharedPrefsUtils
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var listFragment: ListFragment

    @Inject
    lateinit var filmFragment: FilmFragment

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        App.getInstance().appComponent.inject(this)

        val frame = SharedPrefsUtils.getStringPreference(context!!, Constants.PARAM_FRAME)
        when (frame) {
            Constants.KEY_LIST -> {
                btnPeopleOnCLick(view)
            }
            Constants.KEY_FILM -> {
                btnFilmOnClick(view)
            }
        }

        initBtns()
    }

    private fun initBtns() {
        btnFilm.setOnClickListener(::btnFilmOnClick)
        btnPeople.setOnClickListener(::btnPeopleOnCLick)
    }

    private fun btnFilmOnClick(view: View?) {
        fragmentManager?.beginTransaction()
            ?.addToBackStack("PeopleListFragment")
            ?.replace(R.id.container, filmFragment)
            ?.commit()
        SharedPrefsUtils.setStringPreference(context!!, Constants.PARAM_FRAME, Constants.KEY_FILM)
    }

    private fun btnPeopleOnCLick(view: View?) {
        fragmentManager?.beginTransaction()
            ?.addToBackStack("FilmListFragment")
            ?.replace(R.id.container, listFragment)
            ?.commit()
        SharedPrefsUtils.setStringPreference(context!!, Constants.PARAM_FRAME, Constants.KEY_LIST)
    }
}