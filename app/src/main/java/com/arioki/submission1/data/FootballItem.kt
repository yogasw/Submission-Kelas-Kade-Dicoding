package com.arioki.submission1.data

import android.os.Parcel
import android.os.Parcelable

data class FootballItem(
    val id: String?,
    val name: String?,
    val badge: Int,
    val description: String?
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readInt(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(id)
        writeString(name)
        writeInt(badge)
        writeString(description)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<FootballItem> = object : Parcelable.Creator<FootballItem> {
            override fun createFromParcel(source: Parcel): FootballItem = FootballItem(source)
            override fun newArray(size: Int): Array<FootballItem?> = arrayOfNulls(size)
        }
    }
}