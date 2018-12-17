package com.yurentsy.swapi.gui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yurentsy.swapi.App
import com.yurentsy.swapi.R
import com.yurentsy.swapi.gui.fragment.HomeFragment
import com.yurentsy.swapi.utils.Constants
import com.yurentsy.swapi.utils.SharedPrefsUtils
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var homeFragment: HomeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.getInstance().appComponent.inject(this)
        showHomeFragment()
    }

    private fun showHomeFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, homeFragment)
            .commit()
    }

    override fun onBackPressed() {
        SharedPrefsUtils.setStringPreference(this, Constants.PARAM_FRAME, Constants.KEY_HOME)
        super.onBackPressed()
    }
}
