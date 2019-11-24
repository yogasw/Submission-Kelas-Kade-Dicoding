/*
 * *
 *   Created by Yoga Setiawan on 11/24/19 1:54 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/24/19 11:16 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.listTeam

import com.arioki.submission.data.LookupAllTeamItem
import com.arioki.submission.repository.LookupAllTeamRepositoryCallback
import com.arioki.submission.repository.TheSportsDBRepository

class ListTeamPresenter(
    private val view: ListTeamView,
    private val id: Int,
    private val repository: TheSportsDBRepository
) {
    fun getData() {
        repository.lookupAllTeam(id, object : LookupAllTeamRepositoryCallback {
            override fun onError(t: Throwable) {
                view.getDataError(t)
            }

            override fun onSuccess(lookupAllTeamItem: List<LookupAllTeamItem>) {
                view.getDataSuccess(lookupAllTeamItem)
            }
        })
    }

}
