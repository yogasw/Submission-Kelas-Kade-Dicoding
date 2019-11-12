package com.arioki.submission.ui.nextEvent

import com.arioki.submission.data.EventItem

interface NextEventView {

    fun hiddenSimmer()
    fun getDataDone(it: List<EventItem>)
}
