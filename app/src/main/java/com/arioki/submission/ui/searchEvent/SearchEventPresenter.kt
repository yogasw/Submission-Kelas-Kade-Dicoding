/*
 * *
 *   Created by Yoga Setiawan on 11/27/19 10:26 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/27/19 10:26 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.searchEvent

import com.arioki.submission.data.EventItem
import com.arioki.submission.data.LookupAllPlayerItem
import com.arioki.submission.data.LookupAllTeamItem
import com.arioki.submission.repository.LookupAllTeamRepositoryCallback
import com.arioki.submission.repository.LookupPlayersRepositoryCallback
import com.arioki.submission.repository.TheSportsDBRepository
import com.arioki.submission.repository.TheSportsDBRepositoryCallback

class SearchEventPresenter(
    val view: SearchEventView,
    private val repository: TheSportsDBRepository
) {
    fun searchData() {
        view.showShimmer()
        when (view.getSearchType()) {
            "Match" -> searchMatch()
            "Team" -> searchTeam()
            "Player" -> searchPlayer()
            else -> {
                view.hiddenSimmer()
                view.searchError()
            }

        }
    }

    private fun searchPlayer() {
        repository.searchPlayers(view.getTextSearch(), object : LookupPlayersRepositoryCallback {
            override fun onError(t: Throwable) {
                view.hiddenSimmer()
                view.dataEmpty()
            }

            override fun onSuccess(lookupAllPlayerItem: List<LookupAllPlayerItem>) {
                view.hiddenSimmer()
                view.finishSearchPlayer(lookupAllPlayerItem)
            }
        })
    }

    private fun searchTeam() {
        repository.searchTeam(view.getTextSearch(), object : LookupAllTeamRepositoryCallback {
            override fun onError(t: Throwable) {
                view.hiddenSimmer()
                view.dataEmpty()
            }

            override fun onSuccess(lookupAllTeamItem: List<LookupAllTeamItem>) {
                view.hiddenSimmer()
                view.finishSearchTeam(lookupAllTeamItem)
            }
        })
    }

    private fun searchMatch() {
        repository.searchEvent(view.getTextSearch(), object : TheSportsDBRepositoryCallback {
            override fun onError() {
                view.hiddenSimmer()
                view.dataEmpty()
            }

            override fun onSuccess(data: List<EventItem>) {
                view.hiddenSimmer()
                view.finishSearchMatch(data)
            }
        })
    }
}
