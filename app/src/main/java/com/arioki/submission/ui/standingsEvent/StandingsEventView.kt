/*
 * *
 *   Created by Yoga Setiawan on 12/8/19 11:31 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 12/8/19 11:23 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.standingsEvent

import com.arioki.submission.data.StandingsEventItem

interface StandingsEventView {
    fun getDataError(t: Throwable)
    fun getDataSuccess(it: List<StandingsEventItem>)

}
