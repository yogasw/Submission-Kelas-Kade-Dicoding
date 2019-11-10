package com.arioki.submission1.remote.response


import com.google.gson.annotations.SerializedName

data class DetailEventResponse(
    @SerializedName("events")
    val events: List<Event>
) {
    data class Event(
        @SerializedName("dateEvent")
        val dateEvent: String,
        @SerializedName("dateEventLocal")
        val dateEventLocal: String,
        @SerializedName("idAwayTeam")
        val idAwayTeam: String,
        @SerializedName("idEvent")
        val idEvent: String,
        @SerializedName("idHomeTeam")
        val idHomeTeam: String,
        @SerializedName("idLeague")
        val idLeague: String,
        @SerializedName("idSoccerXML")
        val idSoccerXML: String,
        @SerializedName("intAwayScore")
        val intAwayScore: String,
        @SerializedName("intAwayShots")
        val intAwayShots: String,
        @SerializedName("intHomeScore")
        val intHomeScore: String,
        @SerializedName("intHomeShots")
        val intHomeShots: String,
        @SerializedName("intRound")
        val intRound: String,
        @SerializedName("intSpectators")
        val intSpectators: String,
        @SerializedName("strAwayFormation")
        val strAwayFormation: String,
        @SerializedName("strAwayGoalDetails")
        val strAwayGoalDetails: String,
        @SerializedName("strAwayLineupDefense")
        val strAwayLineupDefense: String,
        @SerializedName("strAwayLineupForward")
        val strAwayLineupForward: String,
        @SerializedName("strAwayLineupGoalkeeper")
        val strAwayLineupGoalkeeper: String,
        @SerializedName("strAwayLineupMidfield")
        val strAwayLineupMidfield: String,
        @SerializedName("strAwayLineupSubstitutes")
        val strAwayLineupSubstitutes: String,
        @SerializedName("strAwayRedCards")
        val strAwayRedCards: String,
        @SerializedName("strAwayTeam")
        val strAwayTeam: String,
        @SerializedName("strAwayYellowCards")
        val strAwayYellowCards: String,
        @SerializedName("strBanner")
        val strBanner: Any,
        @SerializedName("strCircuit")
        val strCircuit: Any,
        @SerializedName("strCity")
        val strCity: Any,
        @SerializedName("strCountry")
        val strCountry: Any,
        @SerializedName("strDate")
        val strDate: String,
        @SerializedName("strDescriptionEN")
        val strDescriptionEN: Any,
        @SerializedName("strEvent")
        val strEvent: String,
        @SerializedName("strEventAlternate")
        val strEventAlternate: String,
        @SerializedName("strFanart")
        val strFanart: Any,
        @SerializedName("strFilename")
        val strFilename: String,
        @SerializedName("strHomeFormation")
        val strHomeFormation: String,
        @SerializedName("strHomeGoalDetails")
        val strHomeGoalDetails: String,
        @SerializedName("strHomeLineupDefense")
        val strHomeLineupDefense: String,
        @SerializedName("strHomeLineupForward")
        val strHomeLineupForward: String,
        @SerializedName("strHomeLineupGoalkeeper")
        val strHomeLineupGoalkeeper: String,
        @SerializedName("strHomeLineupMidfield")
        val strHomeLineupMidfield: String,
        @SerializedName("strHomeLineupSubstitutes")
        val strHomeLineupSubstitutes: String,
        @SerializedName("strHomeRedCards")
        val strHomeRedCards: String,
        @SerializedName("strHomeTeam")
        val strHomeTeam: String,
        @SerializedName("strHomeYellowCards")
        val strHomeYellowCards: String,
        @SerializedName("strLeague")
        val strLeague: String,
        @SerializedName("strLocked")
        val strLocked: String,
        @SerializedName("strMap")
        val strMap: Any,
        @SerializedName("strPoster")
        val strPoster: Any,
        @SerializedName("strResult")
        val strResult: Any,
        @SerializedName("strSeason")
        val strSeason: String,
        @SerializedName("strSport")
        val strSport: String,
        @SerializedName("strTVStation")
        val strTVStation: Any,
        @SerializedName("strThumb")
        val strThumb: Any,
        @SerializedName("strTime")
        val strTime: String,
        @SerializedName("strTimeLocal")
        val strTimeLocal: Any,
        @SerializedName("strTweet1")
        val strTweet1: Any,
        @SerializedName("strTweet2")
        val strTweet2: Any,
        @SerializedName("strTweet3")
        val strTweet3: Any,
        @SerializedName("strVideo")
        val strVideo: Any
    )
}