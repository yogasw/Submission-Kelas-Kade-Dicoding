/*
 * *
 *   Created by Yoga Setiawan on 11/27/19 9:31 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/27/19 9:31 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ext

import android.content.Context
import android.widget.Toast

fun Any.toaster(context: Context) {
    Toast.makeText(context, this.toString(), Toast.LENGTH_SHORT).show()
}