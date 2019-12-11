/*
 * *
 *   Created by Yoga Setiawan on 12/11/19 10:22 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/10/19 2:25 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui

import com.arioki.submission.data.EventItem

interface SearchEventView {
    fun hiddenSimmer()
    fun finishLoadData(it: List<EventItem>)
    fun showShimmer()
    fun dataEmpty()
}
