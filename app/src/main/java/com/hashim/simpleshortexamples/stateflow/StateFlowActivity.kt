/*
 * Copyright (c) 2020/  12/ 27.  Created by Hashim Tahir
 */

package com.hashim.simpleshortexamples.stateflow

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.hashim.simpleshortexamples.databinding.ActivityStateFlowBinding
import kotlinx.coroutines.flow.collect

class StateFlowActivity : AppCompatActivity() {
    lateinit var hActivityStateFlowBinding: ActivityStateFlowBinding

    val hStateFlowViewModel: StateFlowViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hActivityStateFlowBinding = ActivityStateFlowBinding.inflate(layoutInflater)
        setContentView(hActivityStateFlowBinding.root)

        hActivityStateFlowBinding.btnLogin.setOnClickListener {
            hStateFlowViewModel.hLoginUser(
                hActivityStateFlowBinding.etUsername.text.toString(),
                hActivityStateFlowBinding.etPassword.text.toString(),

                )
        }


        lifecycleScope.launchWhenStarted {
            hStateFlowViewModel.hLoginUiStateSF.collect {
                when (it) {
                    is StateFlowViewModel.LoginUiState.Success -> {
                        Snackbar.make(
                            hActivityStateFlowBinding.root,
                            "Successfully logged in ",
                            Snackbar.LENGTH_LONG
                        ).show()
                        hActivityStateFlowBinding.progressBar.isVisible = false
                    }

                    is StateFlowViewModel.LoginUiState.Error -> {
                        Snackbar.make(
                            hActivityStateFlowBinding.root,
                            it.message,
                            Snackbar.LENGTH_LONG
                        ).show()
                        hActivityStateFlowBinding.progressBar.isVisible = false
                    }

                    is StateFlowViewModel.LoginUiState.Loading ->
                        hActivityStateFlowBinding.progressBar.isVisible = true

                    else -> Unit
                }
            }
        }
    }
}