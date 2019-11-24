/*
 * *
 *   Created by Yoga Setiawan on 11/24/19 7:48 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/24/19 4:44 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.remote.response


import com.google.gson.annotations.SerializedName

data class LookupAllTeamResponse(
    @SerializedName("teams")
    val teams: List<Team>
) {
    data class Team(
        @SerializedName("idLeague")
        val idLeague: String,
        @SerializedName("idSoccerXML")
        val idSoccerXML: String,
        @SerializedName("idTeam")
        val idTeam: String,
        @SerializedName("intFormedYear")
        val intFormedYear: String,
        @SerializedName("intLoved")
        val intLoved: String,
        @SerializedName("intStadiumCapacity")
        val intStadiumCapacity: String,
        @SerializedName("strAlternate")
        val strAlternate: String,
        @SerializedName("strCountry")
        val strCountry: String,
        @SerializedName("strDescriptionCN")
        val strDescriptionCN: String,
        @SerializedName("strDescriptionDE")
        val strDescriptionDE: String,
        @SerializedName("strDescriptionEN")
        val strDescriptionEN: String,
        @SerializedName("strDescriptionES")
        val strDescriptionES: String,
        @SerializedName("strDescriptionFR")
        val strDescriptionFR: String,
        @SerializedName("strDescriptionHU")
        val strDescriptionHU: String,
        @SerializedName("strDescriptionIL")
        val strDescriptionIL: String,
        @SerializedName("strDescriptionIT")
        val strDescriptionIT: String,
        @SerializedName("strDescriptionJP")
        val strDescriptionJP: String,
        @SerializedName("strDescriptionNL")
        val strDescriptionNL: String,
        @SerializedName("strDescriptionNO")
        val strDescriptionNO: String,
        @SerializedName("strDescriptionPL")
        val strDescriptionPL: String,
        @SerializedName("strDescriptionPT")
        val strDescriptionPT: String,
        @SerializedName("strDescriptionRU")
        val strDescriptionRU: String,
        @SerializedName("strDescriptionSE")
        val strDescriptionSE: String,
        @SerializedName("strDivision")
        val strDivision: String,
        @SerializedName("strFacebook")
        val strFacebook: String,
        @SerializedName("strGender")
        val strGender: String,
        @SerializedName("strInstagram")
        val strInstagram: String,
        @SerializedName("strKeywords")
        val strKeywords: String,
        @SerializedName("strLeague")
        val strLeague: String,
        @SerializedName("strLocked")
        val strLocked: String,
        @SerializedName("strManager")
        val strManager: String,
        @SerializedName("strRSS")
        val strRSS: String,
        @SerializedName("strSport")
        val strSport: String,
        @SerializedName("strStadium")
        val strStadium: String,
        @SerializedName("strStadiumDescription")
        val strStadiumDescription: String,
        @SerializedName("strStadiumLocation")
        val strStadiumLocation: String,
        @SerializedName("strStadiumThumb")
        val strStadiumThumb: String,
        @SerializedName("strTeam")
        val strTeam: String,
        @SerializedName("strTeamBadge")
        val strTeamBadge: String,
        @SerializedName("strTeamBanner")
        val strTeamBanner: String,
        @SerializedName("strTeamFanart1")
        val strTeamFanart1: String,
        @SerializedName("strTeamFanart2")
        val strTeamFanart2: String,
        @SerializedName("strTeamFanart3")
        val strTeamFanart3: String,
        @SerializedName("strTeamFanart4")
        val strTeamFanart4: String,
        @SerializedName("strTeamJersey")
        val strTeamJersey: String,
        @SerializedName("strTeamLogo")
        val strTeamLogo: String,
        @SerializedName("strTeamShort")
        val strTeamShort: String,
        @SerializedName("strTwitter")
        val strTwitter: String,
        @SerializedName("strWebsite")
        val strWebsite: String,
        @SerializedName("strYoutube")
        val strYoutube: String
    )
}