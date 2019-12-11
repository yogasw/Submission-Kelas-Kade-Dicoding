/*
 * *
 *   Created by Yoga Setiawan on 12/11/19 10:46 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/12/19 8:56 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.detailEvent

import com.arioki.submission.data.DetailEventItem
import com.arioki.submission.data.DetailEventListItem

interface DetailEventView {
    fun showShimmer()
    fun hiddenShimmer()
    fun finishLoadData(it: DetailEventItem)
    fun finishLoadDataList(items: MutableList<DetailEventListItem>)
    fun getUrlLogoDone(strTeamBadge: String, team: String)
    fun showAddFavoriteButton()
    fun showRemoveFavoriteButton()
}