package com.arioki.submission.ui

import com.arioki.submission.data.EventItem

interface FavoriteNextEventView {
    fun getDataDone(result: List<EventItem>)
}