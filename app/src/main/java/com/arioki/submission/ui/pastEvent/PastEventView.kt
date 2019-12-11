/*
 * *
 *   Created by Yoga Setiawan on 12/11/19 10:46 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/12/19 8:56 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.pastEvent

import com.arioki.submission.data.EventItem

interface PastEventView {
    fun getDataDone(it: List<EventItem>)

    fun hiddenSimmer()
}
