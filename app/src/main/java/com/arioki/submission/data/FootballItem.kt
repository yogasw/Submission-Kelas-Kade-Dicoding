/*
 * *
 *   Created by Yoga Setiawan on 12/11/19 10:22 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/10/19 11:31 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FootballItem(
    val id: String?,
    val name: String?,
    val badge: Int,
    val description: String?
) : Parcelable