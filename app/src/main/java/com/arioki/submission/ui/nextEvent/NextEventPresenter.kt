/*
 * *
 *   Created by Yoga Setiawan on 12/11/19 10:46 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/15/19 5:02 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.nextEvent


import com.arioki.submission.data.EventItem
import com.arioki.submission.repository.TheSportsDBRepository
import com.arioki.submission.repository.TheSportsDBRepositoryCallback

class NextEventPresenter(
    private val view: NextEventView,
    private val id: Int,
    private val repository: TheSportsDBRepository
) {
    fun getData() {
        repository.nextEvent(id, object : TheSportsDBRepositoryCallback {
            override fun onError() {
                view.hiddenSimmer()
            }

            override fun onSuccess(data: List<EventItem>) {
                view.hiddenSimmer()
                view.getDataDone(data)
            }
        })
    }
}
