package com.example.samsungpay.unitedstatesstatemap

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log.d
import android.view.ViewTreeObserver

/**
 *  Created by JIWEN LI 06/27/2018
 */

class MainActivity : AppCompatActivity() {

    private val TAG: String = MainActivity::class.java.simpleName
    var width: Int = 0
    var height: Int = 0
    //var states: Array<String> = arrayOf("#tx", "#wy", "#ca", "#fl", "#ny", "#ak")
    var states: Array<String> = arrayOf("#az", "#pa", "#wa", "#me", "#la", "#tn", "#fl", "#sd", "#in")
    lateinit var stateMap: CustomImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        stateMap = findViewById(R.id.us_states_map)
        val vto = stateMap.viewTreeObserver
        vto.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                stateMap.viewTreeObserver.removeOnPreDrawListener(this)
                height = stateMap.measuredHeight
                width = stateMap.measuredWidth
                showHighlightStatesWithColor(states, "#303f9f")
                d(TAG, "Image measuredWidth is $width")
                d(TAG, "Image measuredHeight is $height")
                return true
            }
        })

    }

    /**
     *  Public API
     */
    fun showHighlightStatesWithColor(states: Array<String>?, color: String) {
        stateMap.forceInvalidate(width, height, states, color)
    }


}
