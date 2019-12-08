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
import com.arioki.submission.repository.StandingsEventRepositoryCallback
import com.arioki.submission.repository.TheSportsDBRepository

class StandingsEventPresenter(
    val view: StandingsEventView,
    val repository: TheSportsDBRepository
) {
    fun getData(id: Int) {
        repository.standingsMatch(id, object : StandingsEventRepositoryCallback {
            override fun onError(t: Throwable) {
                view.getDataError(t)
            }

            override fun onSuccess(it: List<StandingsEventItem>) {
                view.getDataSuccess(it)
            }
        })
    }

}
