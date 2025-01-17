/*
 * Copyright (c) 2020/  12/ 27.  Created by Hashim Tahir
 */

package com.hashim.simpleshortexamples

import android.app.Application
import timber.log.Timber

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        hInitTimber()
    }

    private fun hInitTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                    super.log(priority, java.lang.String.format(Constants.hTag, tag), message, t)
                }
            })
        }
    }
}