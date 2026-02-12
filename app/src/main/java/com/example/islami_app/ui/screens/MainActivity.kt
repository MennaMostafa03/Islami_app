package com.example.islami_app.ui.screens.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import com.example.islami_app.R
import com.example.islami_app.ui.screens.main.fragments.quran.HadethFragment
import com.example.islami_app.ui.screens.main.fragments.quran.QuranFragment
import com.example.islami_app.ui.screens.main.fragments.quran.SebhaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showFragment(QuranFragment())
        bottomNav = findViewById(R.id.bottomNav)

        // this interface return boolean and take menuItem as parameter
        // in case i have 1 parameter and i use lambda expression i can use "it" that refer to the parameter that will send in interface,..etc
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.quranTab -> {
                    showFragment(QuranFragment())
                    true
                }

                R.id.hadithTab -> {
                    showFragment(HadethFragment())
                    true
                }

                R.id.sebhaTab -> {
                    showFragment(SebhaFragment())
                    true
                }

                R.id.radioTab -> {
                    Toast.makeText(this, "Not Implemented yet", Toast.LENGTH_SHORT).show()
                    false
                }

                else -> false
            }
        }

    }

    fun showFragment(fragment: Fragment)  {
        supportFragmentManager.beginTransaction()
            .replace(R.id.contentFrameLayout, fragment)
            .commit()
    }

}