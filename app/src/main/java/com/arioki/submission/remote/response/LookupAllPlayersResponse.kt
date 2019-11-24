/*
 * *
 *   Created by Yoga Setiawan on 11/24/19 1:54 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/24/19 1:51 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.remote.response


import com.google.gson.annotations.SerializedName

data class LookupAllPlayersResponse(
    @SerializedName("player")
    val player: List<Player>
) {
    data class Player(
        @SerializedName("dateBorn")
        val dateBorn: String,
        @SerializedName("dateSigned")
        val dateSigned: String,
        @SerializedName("idPlayer")
        val idPlayer: String,
        @SerializedName("idPlayerManager")
        val idPlayerManager: String,
        @SerializedName("idSoccerXML")
        val idSoccerXML: String,
        @SerializedName("idTeam")
        val idTeam: String,
        @SerializedName("idTeam2")
        val idTeam2: String,
        @SerializedName("idTeamNational")
        val idTeamNational: Any,
        @SerializedName("intLoved")
        val intLoved: String,
        @SerializedName("intSoccerXMLTeamID")
        val intSoccerXMLTeamID: String,
        @SerializedName("strAgent")
        val strAgent: String,
        @SerializedName("strBanner")
        val strBanner: String,
        @SerializedName("strBirthLocation")
        val strBirthLocation: String,
        @SerializedName("strCollege")
        val strCollege: Any,
        @SerializedName("strCreativeCommons")
        val strCreativeCommons: String,
        @SerializedName("strCutout")
        val strCutout: String,
        @SerializedName("strDescriptionCN")
        val strDescriptionCN: Any,
        @SerializedName("strDescriptionDE")
        val strDescriptionDE: Any,
        @SerializedName("strDescriptionEN")
        val strDescriptionEN: String,
        @SerializedName("strDescriptionES")
        val strDescriptionES: String,
        @SerializedName("strDescriptionFR")
        val strDescriptionFR: String,
        @SerializedName("strDescriptionHU")
        val strDescriptionHU: Any,
        @SerializedName("strDescriptionIL")
        val strDescriptionIL: Any,
        @SerializedName("strDescriptionIT")
        val strDescriptionIT: Any,
        @SerializedName("strDescriptionJP")
        val strDescriptionJP: Any,
        @SerializedName("strDescriptionNL")
        val strDescriptionNL: Any,
        @SerializedName("strDescriptionNO")
        val strDescriptionNO: Any,
        @SerializedName("strDescriptionPL")
        val strDescriptionPL: Any,
        @SerializedName("strDescriptionPT")
        val strDescriptionPT: Any,
        @SerializedName("strDescriptionRU")
        val strDescriptionRU: Any,
        @SerializedName("strDescriptionSE")
        val strDescriptionSE: Any,
        @SerializedName("strFacebook")
        val strFacebook: String,
        @SerializedName("strFanart1")
        val strFanart1: String,
        @SerializedName("strFanart2")
        val strFanart2: String,
        @SerializedName("strFanart3")
        val strFanart3: String,
        @SerializedName("strFanart4")
        val strFanart4: String,
        @SerializedName("strGender")
        val strGender: String,
        @SerializedName("strHeight")
        val strHeight: String,
        @SerializedName("strInstagram")
        val strInstagram: String,
        @SerializedName("strKit")
        val strKit: String,
        @SerializedName("strLocked")
        val strLocked: String,
        @SerializedName("strNationality")
        val strNationality: String,
        @SerializedName("strNumber")
        val strNumber: String,
        @SerializedName("strOutfitter")
        val strOutfitter: String,
        @SerializedName("strPlayer")
        val strPlayer: String,
        @SerializedName("strPosition")
        val strPosition: String,
        @SerializedName("strRender")
        val strRender: String,
        @SerializedName("strSide")
        val strSide: String,
        @SerializedName("strSigning")
        val strSigning: String,
        @SerializedName("strSport")
        val strSport: String,
        @SerializedName("strTeam")
        val strTeam: String,
        @SerializedName("strTeam2")
        val strTeam2: String,
        @SerializedName("strThumb")
        val strThumb: String,
        @SerializedName("strTwitter")
        val strTwitter: String,
        @SerializedName("strWage")
        val strWage: String,
        @SerializedName("strWebsite")
        val strWebsite: String,
        @SerializedName("strWeight")
        val strWeight: String,
        @SerializedName("strYoutube")
        val strYoutube: String
    )
}