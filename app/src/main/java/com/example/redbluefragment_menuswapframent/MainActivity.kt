package com.example.redbluefragment_menuswapframent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.bottomnavigation.BottomNavigationView



class MainActivity : AppCompatActivity() {

    private lateinit var containerView: View
    private lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        containerView = findViewById(R.id.fragment_container)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.show_red -> {
                    showFragment("RED")
                    true
                }
                R.id.show_blue -> {
                    showFragment("BLUE")
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun showFragment(tag: String) {

        // is the fragment currently on the screen
        // is the fragment not on screen -> display request fragment
        if (supportFragmentManager.findFragmentByTag(tag) == null) {
            when (tag) {
                "RED" -> {
                    // display the red fragment
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, RedFragment.newInstance(), "RED")
                        .commit()
                }
                "BLUE" -> {
                    // display the blue fragment
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, BlueFragment.newInstance(), "BLUE")
                        .commit()
                }
            }
        }
    }

//    private fun showFragment(tag: String) {
//        // if the fragment requested is not on the screen,
//        if (supportFragmentManager.findFragmentByTag(tag) == null) {
//            when (tag) {
//                "RED" -> {
//                    // replace the current fragment with the red fragment
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.fragment_container, RedFragment.newInstance(), "RED")
//                        .commit()
//
//                    /*
//                    // Alternative - need the Android KTX library, add to build.gradle for the module
//                    // https://developer.android.com/kotlin/ktx#fragment
//                    // Simplify code to the following, harder to forget to call .commit
//                    supportFragmentManager.commit {
//                        // beginTransaction()  // not needed
//                        replace(R.id.fragment_container, RedFragment.newInstance(), "RED")
//                    }
//                     */
//
//                }
//                "BLUE" -> {
//                    // Otherwise, replace the current fragment with the blue fragment
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.fragment_container, BlueFragment.newInstance(), "BLUE")
//                        .commit()
//                }
//            }
//        }
//    }
}