/*
 * *
 *   Created by Yoga Setiawan on 11/25/19 5:57 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/25/19 5:53 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TeamInfoItem(
    val title: String?,
    val value: String?
) : Parcelable