package com.arioki.submission.ui.searchEvent

import com.arioki.submission.data.EventItem

interface SearchEventView {
    fun hiddenSimmer()
    fun finishLoadData(it: List<EventItem>)
    fun showShimmer()
    fun dataEmpty()
}
