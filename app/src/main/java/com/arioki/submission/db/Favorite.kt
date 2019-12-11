/*
 * *
 *   Created by Yoga Setiawan on 12/11/19 10:46 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/12/19 8:56 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.db

data class Favorite(
    val dateEvent: String?,
    val dateEventLocal: String?,
    val idAwayTeam: String?,
    val idEvent: String,
    val idHomeTeam: String?,
    val intAwayScore: String?,
    val intAwayShots: String?,
    val intHomeScore: String?,
    val intHomeShots: String?,
    val intRound: String?,
    val intSpectators: String?,
    val strAwayFormation: String?,
    val strAwayGoalDetails: String?,
    val strAwayLineupDefense: String?,
    val strAwayLineupForward: String?,
    val strAwayLineupGoalkeeper: String?,
    val strAwayLineupMidfield: String?,
    val strAwayLineupSubstitutes: String?,
    val strAwayRedCards: String?,
    val strAwayTeam: String?,
    val strAwayYellowCards: String?,
    val strDate: String?,
    val strEvent: String?,
    val strEventAlternate: String?,
    val strFilename: String?,
    val strHomeFormation: String?,
    val strHomeGoalDetails: String?,
    val strHomeLineupDefense: String?,
    val strHomeLineupForward: String?,
    val strHomeLineupGoalkeeper: String?,
    val strHomeLineupMidfield: String?,
    val strHomeLineupSubstitutes: String?,
    val strHomeRedCards: String?,
    val strHomeTeam: String?,
    val strHomeYellowCards: String?,
    val strLeague: String?,
    val strSeason: String?,
    val strSport: String?,
    val strTime: String?,
    val srLogoHome: String?,
    val strLogoAway: String?
) {
    companion object {
        const val tbName: String = "tableFavorite"
        const val fdateEventLocal: String = "dateEventLocal"
        const val fidAwayTeam: String = "idAwayTeam"
        const val fidEvent: String = "idEvent"
        const val fidHomeTeam: String = "idHomeTeam"
        const val fintAwayScore: String = "intAwayScore"
        const val fintAwayShots: String = "intAwayShots"
        const val fintHomeScore: String = "intHomeScore"
        const val fintHomeShots: String = "intHomeShots"
        const val fintRound: String = "intRound"
        const val fintSpectators: String = "intSpectators"
        const val fstrAwayFormation: String = "strAwayFormation"
        const val fstrAwayGoalDetails: String = "strAwayGoalDetails"
        const val fstrAwayLineupDefense: String = "strAwayLineupDefense"
        const val fstrAwayLineupForward: String = "strAwayLineupForward"
        const val fstrAwayLineupGoalkeeper: String = "strAwayLineupGoalkeeper"
        const val fstrAwayLineupMidfield: String = "strAwayLineupMidfield"
        const val fstrAwayLineupSubstitutes: String = "strAwayLineupSubstitutes"
        const val fstrAwayRedCards: String = "strAwayRedCards"
        const val fstrAwayTeam: String = "strAwayTeam"
        const val fstrAwayYellowCards: String = "strAwayYellowCards"
        const val fstrDate: String = "strDate"
        const val fstrEvent: String = "strEvent"
        const val fstrEventAlternate: String = "strEventAlternate"
        const val fstrFilename: String = "strFilename"
        const val fstrHomeFormation: String = "strHomeFormation"
        const val fstrHomeGoalDetails: String = "strHomeGoalDetails"
        const val fstrHomeLineupDefense: String = "strHomeLineupDefense"
        const val fstrHomeLineupForward: String = "strHomeLineupForward"
        const val fstrHomeLineupGoalkeeper: String = "strHomeLineupGoalkeeper"
        const val fstrHomeLineupMidfield: String = "strHomeLineupMidfield"
        const val fstrHomeLineupSubstitutes: String = "strHomeLineupSubstitutes"
        const val fstrHomeRedCards: String = "strHomeRedCards"
        const val fstrHomeTeam: String = "strHomeTeam"
        const val fstrHomeYellowCards: String = "strHomeYellowCards"
        const val fstrLeague: String = "strLeague"
        const val fstrSeason: String = "strSeason"
        const val fstrSport: String = "strSport"
        const val fstrTime: String = "strTime"
        const val fstrLogoHome: String = "strLogoHome"
        const val fstrLogoAway: String = "strLogoAway"
    }
}
