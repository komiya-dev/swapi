package com.yurentsy.swapi.gui.fragment

import android.content.Intent
import android.net.Uri
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
    lateinit var filmFragment: FilmFragment
    @Inject
    lateinit var peopleFragment: PeopleFragment

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
            Constants.KEY_PEOPLE -> {
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
        imgGithub.setOnClickListener(::imgGithubOnClick)
    }

    private fun btnFilmOnClick(view: View?) {
        fragmentManager?.beginTransaction()
            ?.addToBackStack("FilmListFragment")
            ?.replace(R.id.container, filmFragment)
            ?.commit()
        SharedPrefsUtils.setStringPreference(context!!, Constants.PARAM_FRAME, Constants.KEY_FILM)
    }

    private fun btnPeopleOnCLick(view: View?) {
        fragmentManager?.beginTransaction()
            ?.addToBackStack("PeopleListFragment")
            ?.replace(R.id.container, peopleFragment)
            ?.commit()
        SharedPrefsUtils.setStringPreference(context!!, Constants.PARAM_FRAME, Constants.KEY_PEOPLE)
    }

    private fun imgGithubOnClick(view: View?) {
        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        intent.addCategory(Intent.CATEGORY_BROWSABLE)
        intent.data = Uri.parse("https://github.com/yurentsy/swapi/")
        startActivity(intent)
    }
}