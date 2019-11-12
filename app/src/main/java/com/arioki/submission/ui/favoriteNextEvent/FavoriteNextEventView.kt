package com.arioki.submission.ui.favoriteNextEvent

import com.arioki.submission.data.EventItem

interface FavoriteNextEventView {
    fun getDataDone(result: List<EventItem>)
}