/*
 * *
 *   Created by Yoga Setiawan on 11/15/19 9:03 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/15/19 8:56 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.detailLiga

import com.arioki.submission.data.LeaguesItem
import com.arioki.submission.repository.DetailLigaRepositoryCallback
import com.arioki.submission.repository.TheSportsDBRepository

class DetailLigaPresenter(
    var view: DetailLigaView,
    var id: Int,
    var repository: TheSportsDBRepository
) {
    fun getDetailLiga() {
        view.startShimmer()
        repository.leaguesLookup(id, object : DetailLigaRepositoryCallback {
            override fun onError() {
                view.getDetailLigaFailed()
            }

            override fun onSuccess(leaguesItem: LeaguesItem) {
                view.getDetaiLigaDone(leaguesItem)
            }
        })
    }

}
