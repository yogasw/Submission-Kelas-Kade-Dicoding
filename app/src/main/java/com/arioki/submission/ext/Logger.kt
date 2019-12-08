/*
 * *
 *   Created by Yoga Setiawan on 12/8/19 11:31 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/28/19 8:35 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ext

import android.util.Log

fun Any.logger(TAG: String = "LogApp"): Int {
    return Log.d(TAG, this.toString())
}