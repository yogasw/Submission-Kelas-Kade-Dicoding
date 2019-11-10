package com.arioki.submission1.ui

import com.arioki.submission1.data.DetailEventItem

interface DetailEventView {
    fun showShimmer()
    fun hiddenShimmer()
    fun finishLoadData(it: DetailEventItem)

}