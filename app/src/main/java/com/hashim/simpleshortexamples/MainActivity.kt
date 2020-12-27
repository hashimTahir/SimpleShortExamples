/*
 * Copyright (c) 2020/  12/ 26.  Created by Hashim Tahir
 */

package com.hashim.simpleshortexamples

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hashim.simpleshortexamples.curvedbottombar.BottomBarActivity
import com.hashim.simpleshortexamples.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var hActivityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_SimpleShortExamples)

        hActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(hActivityMainBinding.root)

        hActivityMainBinding.hCurvedBottomBarB.setOnClickListener {
            startActivity(
                    Intent(
                            this,
                            BottomBarActivity::class.java
                    )
            )
        }

    }
}