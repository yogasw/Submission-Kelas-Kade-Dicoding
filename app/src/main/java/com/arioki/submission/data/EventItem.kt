/*
 * *
 *   Created by Yoga Setiawan on 12/11/19 10:46 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/12/19 8:56 AM
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