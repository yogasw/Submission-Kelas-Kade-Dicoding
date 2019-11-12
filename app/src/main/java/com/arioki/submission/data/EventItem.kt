/*
 * *
 *   Created by Yoga Setiawan on 11/12/19 8:56 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/12/19 7:15 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

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