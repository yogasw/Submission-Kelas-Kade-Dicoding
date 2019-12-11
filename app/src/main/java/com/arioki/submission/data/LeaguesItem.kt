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
data class LeaguesItem(
    val dateFirstEvent: String?,
    val idLeague: String?,
    val strLeague: String?,
    val strBadge: String?,
    val strGender: String?,
    val strCountry: String?
) : Parcelable