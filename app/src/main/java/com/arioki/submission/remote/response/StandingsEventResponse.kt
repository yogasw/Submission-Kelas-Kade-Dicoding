/*
 * *
 *   Created by Yoga Setiawan on 12/8/19 11:31 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/28/19 4:55 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.remote.response


import com.google.gson.annotations.SerializedName

data class StandingsEventResponse(
    @SerializedName("table")
    val table: List<Table>
) {
    data class Table(
        @SerializedName("draw")
        val draw: Int,
        @SerializedName("goalsagainst")
        val goalsagainst: Int,
        @SerializedName("goalsdifference")
        val goalsdifference: Int,
        @SerializedName("goalsfor")
        val goalsfor: Int,
        @SerializedName("loss")
        val loss: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("played")
        val played: Int,
        @SerializedName("teamid")
        val teamid: String,
        @SerializedName("total")
        val total: Int,
        @SerializedName("win")
        val win: Int
    )
}