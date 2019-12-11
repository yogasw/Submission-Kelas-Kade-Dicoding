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