package com.arioki.submission.ui

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