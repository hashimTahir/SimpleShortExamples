/*
 * Copyright (c) 2020/  12/ 27.  Created by Hashim Tahir
 */

package com.hashim.simpleshortexamples.kotlinflows

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hashim.simpleshortexamples.databinding.ActivityKotlinFlowsBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import timber.log.Timber

class KotlinFlowsActivity : AppCompatActivity() {
    lateinit var hActivityKotlinFlowsBinding: ActivityKotlinFlowsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hActivityKotlinFlowsBinding = ActivityKotlinFlowsBinding.inflate(layoutInflater)
        setContentView(hActivityKotlinFlowsBinding.root)

        val hFlowProducer = flow<String> {
            for (i in 1..10) {
                emit("Hello")
                delay(1000L)
            }

        }

        GlobalScope.launch {
            hFlowProducer.buffer().collect {
                Timber.d("Consumer is %s", it)
            }
        }


    }
}