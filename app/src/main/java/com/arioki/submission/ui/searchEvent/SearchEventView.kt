/*
 * *
 *   Created by Yoga Setiawan on 11/12/19 8:56 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/12/19 8:56 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *  
 */

package com.arioki.submission.ui.searchEvent

import com.arioki.submission.data.EventItem

interface SearchEventView {
    fun getTextSearch(): String
    fun hiddenSimmer()
    fun finishLoadData(it: List<EventItem>)
    fun showShimmer()
    fun dataEmpty()
}
