/*
 * Copyright (c) 2020/  12/ 27.  Created by Hashim Tahir
 */

package com.hashim.simpleshortexamples.curvedbottombar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hashim.simpleshortexamples.databinding.ActivityBottomBarBinding

class BottomBarActivity : AppCompatActivity() {
    lateinit var hActivityBottomBarBinding: ActivityBottomBarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hActivityBottomBarBinding = ActivityBottomBarBinding.inflate(layoutInflater)
        setContentView(hActivityBottomBarBinding.root)
        hActivityBottomBarBinding.hBottomNabView.background = null

        hActivityBottomBarBinding.hBottomNabView.menu
            .getItem(2).isEnabled = false
    }
}