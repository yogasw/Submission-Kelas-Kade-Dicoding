/*
 * *
 *   Created by Yoga Setiawan on 11/12/19 8:56 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/12/19 7:21 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.searchEvent

import com.arioki.submission.data.EventItem
import com.arioki.submission.repository.TheSportsDBRepository
import com.arioki.submission.repository.TheSportsDBRepositoryCallback

class SearchEventPresenter(
    val view: SearchEventView,
    private val repository: TheSportsDBRepository
) {
    fun searchData() {
        view.showShimmer()
        repository.searchEvent(view.getTextSearch(), object : TheSportsDBRepositoryCallback {
            override fun onError() {
                view.dataEmpty()
            }

            override fun onSuccess(data: List<EventItem>) {
                view.hiddenSimmer()
                view.finishLoadData(data)
            }
        })
    }
}
