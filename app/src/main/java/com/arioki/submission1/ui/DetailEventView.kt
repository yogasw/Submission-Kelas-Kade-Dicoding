package com.arioki.submission1.ui

import com.arioki.submission1.data.DetailEventItem
import com.arioki.submission1.data.DetailEventListItem

interface DetailEventView {
    fun showShimmer()
    fun hiddenShimmer()
    fun finishLoadData(it: DetailEventItem)
    fun finishLoadDataList(items: MutableList<DetailEventListItem>)

}