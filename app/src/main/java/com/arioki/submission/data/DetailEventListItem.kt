package com.arioki.submission.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetailEventListItem(
    val home: String?,
    val title: String?,
    val away: String?
) : Parcelable