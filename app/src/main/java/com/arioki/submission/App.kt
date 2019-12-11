/*
 * *
 *   Created by Yoga Setiawan on 12/11/19 10:46 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/12/19 8:56 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission

import android.app.Application
import com.arioki.submission.db.SportDBHelper
import com.arioki.submission.remote.TheSportsDBApi
import com.arioki.submission.repository.TheSportsDBRepository

class App : Application() {
    val database: SportDBHelper
        get() = SportDBHelper.getInstance(applicationContext)
    val repository: TheSportsDBRepository by lazy {
        TheSportsDBRepository(TheSportsDBApi.create())
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        @Volatile
        private var INSTANCE: App? = null
        val instances: App
            get() {
                if (INSTANCE == null) {
                    synchronized(App::class.java) {
                        if (INSTANCE == null) {
                            throw RuntimeException("Something went wrong!")
                        }
                    }
                }
                return INSTANCE!!
            }
    }
}