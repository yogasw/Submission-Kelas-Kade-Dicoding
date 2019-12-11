/*
 * *
 *   Created by Yoga Setiawan on 12/11/19 10:22 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/10/19 11:31 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission

import android.app.Application
import com.arioki.submission.remote.ThesportsDBApi
import com.arioki.submission.repository.ThesportsDBRepository

class App : Application() {
    val repository: ThesportsDBRepository by lazy {
        ThesportsDBRepository(ThesportsDBApi.create())
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