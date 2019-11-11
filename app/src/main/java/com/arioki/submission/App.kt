package com.arioki.submission

import android.app.Application
import com.arioki.submission.remote.TheSportsDBApi
import com.arioki.submission.repository.TheSportsDBRepository

class App : Application() {
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