/*
 * Copyright (c) 2020/  12/ 27.  Created by Hashim Tahir
 */

package com.hashim.simpleshortexamples.cropimage

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity
import com.hashim.simpleshortexamples.databinding.ActivityCropImageExampleBinding
import com.theartofdev.edmodo.cropper.CropImage

class CropImageActivity : AppCompatActivity() {
    lateinit var hActivityCropImageExampleBinding: ActivityCropImageExampleBinding

    private lateinit var hCropActivityResultLauncher: ActivityResultLauncher<Any?>

    private val hCropActivityResultContract = object : ActivityResultContract<Any?, Uri>() {
        override fun createIntent(context: Context, input: Any?): Intent {
            return CropImage.activity()
                .setAspectRatio(16, 9)
                .getIntent(this@CropImageActivity)
        }

        override fun parseResult(resultCode: Int, intent: Intent?): Uri? {
            return CropImage.getActivityResult(intent)?.uri
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hActivityCropImageExampleBinding = ActivityCropImageExampleBinding.inflate(layoutInflater)
        setContentView(hActivityCropImageExampleBinding.root)

        hCropActivityResultLauncher = registerForActivityResult(hCropActivityResultContract) {
            it?.let {
                hActivityCropImageExampleBinding.hCropedIv.setImageURI(it)
            }
        }


        hActivityCropImageExampleBinding.hChoseImageB.setOnClickListener {
            hCropActivityResultLauncher.launch(null)
        }


    }
}