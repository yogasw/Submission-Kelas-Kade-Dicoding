package com.arioki.submission.ui.pastEvent

import com.arioki.submission.data.EventItem

interface PastEventView {
    fun getDataDone(it: List<EventItem>)

    fun hiddenSimmer()
}
