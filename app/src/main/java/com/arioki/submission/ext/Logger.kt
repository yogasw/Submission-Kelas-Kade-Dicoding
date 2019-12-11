package com.arioki.submission.ext

import android.content.Context
import android.util.Log

fun Any.logger(context: Context): Int {
    return Log.d("LogApp", this.toString())
}