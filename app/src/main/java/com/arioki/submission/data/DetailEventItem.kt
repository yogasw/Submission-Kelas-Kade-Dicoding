package com.arioki.submission.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetailEventItem(
    val dateEvent: String?,
    val dateEventLocal: String?,
    val idAwayTeam: String?,
    val idEvent: String?,
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
    val strLogoHome: String?,
    val strLogoAway: String?
) : Parcelable