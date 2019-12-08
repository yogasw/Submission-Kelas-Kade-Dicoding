/*
 * *
 *   Created by Yoga Setiawan on 12/8/19 11:31 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/28/19 4:55 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.repository

import com.arioki.submission.data.StandingsEventItem

interface StandingsEventRepositoryCallback {
    fun onError(t: Throwable)
    fun onSuccess(it: List<StandingsEventItem>)
}
