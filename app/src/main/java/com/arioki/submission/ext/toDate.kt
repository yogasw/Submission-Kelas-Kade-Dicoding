/*
 * *
 *   Created by Yoga Setiawan on 12/11/19 10:46 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/13/19 7:50 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *  
 */

package com.arioki.submission.ext

import java.text.SimpleDateFormat
import java.util.*

fun String.toDate(
    dateFormat: String = "yyyy-MM-dd HH:mm:ss",
    timeZone: TimeZone = TimeZone.getTimeZone("UTC")
): Date {
    val parser = SimpleDateFormat(dateFormat, Locale.getDefault())
    parser.timeZone = timeZone
    return parser.parse(this)
}