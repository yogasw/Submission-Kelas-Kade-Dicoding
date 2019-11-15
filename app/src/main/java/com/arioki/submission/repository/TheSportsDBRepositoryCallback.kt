/*
 * *
 *   Created by Yoga Setiawan on 11/15/19 8:08 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/15/19 8:08 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.repository

import com.arioki.submission.data.EventItem

interface TheSportsDBRepositoryCallback {
    fun onError()
    fun onSuccess(data: List<EventItem>)
}
