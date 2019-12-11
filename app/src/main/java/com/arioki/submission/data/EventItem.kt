package com.arioki.submission.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EventItem(
    var id: String?,
    var idHomeTeam: String?,
    var idAwayTeam: String?,
    var name: String?,
    var date: String?,
    var time: String?,
    val homeTeam: String?,
    val awayTeam: String?,
    val homeTeamScore: String?,
    val awayTeamScore: String?,
    var thumbnails: String?
) : Parcelable