/*
 * *
 *   Created by Yoga Setiawan on 11/15/19 3:38 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/15/19 3:38 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.repository

import com.arioki.submission.data.DetailEventItem

interface DetailEventCallback {
    fun onError()
    fun onSuccess(it: List<DetailEventItem>)
}
