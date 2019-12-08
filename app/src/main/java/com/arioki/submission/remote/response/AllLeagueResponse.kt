/*
 * *
 *   Created by Yoga Setiawan on 12/8/19 11:31 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/27/19 10:45 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.remote.response


import com.google.gson.annotations.SerializedName

data class AllLeagueResponse(
    @SerializedName("leagues")
    val leagues: List<League>
) {
    data class League(
        @SerializedName("idLeague")
        val idLeague: String,
        @SerializedName("strLeague")
        val strLeague: String,
        @SerializedName("strLeagueAlternate")
        val strLeagueAlternate: String,
        @SerializedName("strSport")
        val strSport: String
    )
}