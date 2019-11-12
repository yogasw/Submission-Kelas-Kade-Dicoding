/*
 * *
 *   Created by Yoga Setiawan on 11/12/19 8:56 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/12/19 7:19 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.pastEvent

import com.arioki.submission.data.EventItem

interface PastEventView {
    fun getDataDone(it: List<EventItem>)

    fun hiddenSimmer()
}
