/*
 * *
 *   Created by Yoga Setiawan on 11/27/19 9:31 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/27/19 9:31 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.listPlayers

import com.arioki.submission.data.LookupAllPlayerItem
import com.arioki.submission.data.LookupAllTeamItem
import com.arioki.submission.repository.LookupPlayersRepositoryCallback
import com.arioki.submission.repository.TheSportsDBRepository

class ListPlayersPresenter(
    val view: ListPlayersView,
    private val dataTeam: LookupAllTeamItem?,
    val repository: TheSportsDBRepository
) {
    fun getDataPlayers() {
        dataTeam?.run {
            val id = idTeam ?: "0"
            repository.lookupAllPlayers(id.toInt(), object : LookupPlayersRepositoryCallback {
                override fun onError(t: Throwable) {
                    view.getDataPlayersError(t)
                }

                override fun onSuccess(lookupAllPlayerItem: List<LookupAllPlayerItem>) {
                    view.getDataPlayersSuccess(lookupAllPlayerItem)
                }
            })
        }

    }

}
