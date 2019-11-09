package com.arioki.submission1.data


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