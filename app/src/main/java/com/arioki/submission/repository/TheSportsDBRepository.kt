/*
 * *
 *   Created by Yoga Setiawan on 11/12/19 8:56 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/12/19 7:15 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.repository

import com.arioki.submission.data.DetailEventItem
import com.arioki.submission.data.EventItem
import com.arioki.submission.data.LeaguesItem
import com.arioki.submission.data.LookupTeamItem
import com.arioki.submission.remote.TheSportsDBApi
import com.arioki.submission.remote.response.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TheSportsDBRepository(private val api: TheSportsDBApi.Api) {

    fun leaguesLookup(id: Int, onSuccess: (LeaguesItem) -> Unit, onError: (Throwable) -> Unit) {
        api.leaguesLookupResponse(id).enqueue(object : Callback<LeaguesLookupResponse> {
            override fun onFailure(call: Call<LeaguesLookupResponse>, t: Throwable) {
                onError(t)
            }

            override fun onResponse(
                call: Call<LeaguesLookupResponse>,
                response: Response<LeaguesLookupResponse>
            ) {
                if (response.isSuccessful) {
                    val result = response.body()?.leagues?.map {
                        with(it) {
                            LeaguesItem(
                                dateFirstEvent,
                                idLeague,
                                strLeague,
                                strBadge,
                                strGender,
                                strCountry
                            )
                        }
                    }
                    result?.let {
                        onSuccess(it[0])
                    } ?: run {
                        onError(Throwable("Data Empty!"))
                    }
                } else {
                    onError(Throwable("Something went wrong!"))
                }
            }

        })
    }

    fun nextEvent(id: Int, onSuccess: (List<EventItem>) -> Unit, onError: (Throwable) -> Unit) {
        api.leaguesNextEvent(id).enqueue(object : Callback<NextEventResponse> {
            override fun onFailure(call: Call<NextEventResponse>, t: Throwable) {
                onError(t)
            }

            override fun onResponse(
                call: Call<NextEventResponse>,
                response: Response<NextEventResponse>
            ) {
                if (response.isSuccessful) {
                    val result = response.body()?.events?.map {
                        with(it) {
                            EventItem(
                                idEvent,
                                idHomeTeam,
                                idAwayTeam,
                                strEvent,
                                dateEvent,
                                strTime,
                                strHomeTeam,
                                strAwayTeam,
                                intHomeScore,
                                intAwayScore,
                                strThumb
                            )
                        }
                    }
                    result?.let {
                        onSuccess(it)
                    } ?: run {
                        onError(Throwable("Data Empty!"))
                    }
                } else {
                    onError(Throwable("Something went wrong!"))
                }
            }

        })
    }

    fun pastEvent(id: Int, onSuccess: (List<EventItem>) -> Unit, onError: (Throwable) -> Unit) {
        api.leaguesPastEvent(id).enqueue(object : Callback<PastEventResponse> {
            override fun onFailure(call: Call<PastEventResponse>, t: Throwable) {
                onError(t)
            }

            override fun onResponse(
                call: Call<PastEventResponse>,
                response: Response<PastEventResponse>
            ) {
                if (response.isSuccessful) {
                    val result = response.body()?.events?.map {
                        with(it) {
                            EventItem(
                                idEvent,
                                idHomeTeam,
                                idAwayTeam,
                                strEvent,
                                dateEvent,
                                strTime,
                                strHomeTeam,
                                strAwayTeam,
                                intHomeScore,
                                intAwayScore,
                                strThumb
                            )
                        }
                    }
                    result?.let {
                        onSuccess(it)
                    } ?: run {
                        onError(Throwable("Data Empty!"))
                    }
                } else {
                    onError(Throwable("Something went wrong!"))
                }
            }

        })
    }

    fun detailEvent(id: Int, callback: DetailEventCallback) {
        api.lookupEvent(id).enqueue(object : Callback<DetailEventResponse> {
            override fun onFailure(call: Call<DetailEventResponse>, t: Throwable) {
                callback.onError()
            }

            override fun onResponse(
                call: Call<DetailEventResponse>,
                response: Response<DetailEventResponse>
            ) {
                if (response.isSuccessful) {
                    val result = response.body()?.events?.map {
                        with(it) {
                            DetailEventItem(
                                dateEvent,
                                dateEventLocal,
                                idAwayTeam,
                                idEvent,
                                idHomeTeam,
                                intAwayScore,
                                intAwayShots,
                                intHomeScore,
                                intHomeShots,
                                intRound,
                                intSpectators,
                                strAwayFormation,
                                strAwayGoalDetails,
                                strAwayLineupDefense,
                                strAwayLineupForward,
                                strAwayLineupGoalkeeper,
                                strAwayLineupMidfield,
                                strAwayLineupSubstitutes,
                                strAwayRedCards,
                                strAwayTeam,
                                strAwayYellowCards,
                                strDate,
                                strEvent,
                                strEventAlternate,
                                strFilename,
                                strHomeFormation,
                                strHomeGoalDetails,
                                strHomeLineupDefense,
                                strHomeLineupForward,
                                strHomeLineupGoalkeeper,
                                strHomeLineupMidfield,
                                strHomeLineupSubstitutes,
                                strHomeRedCards,
                                strHomeTeam,
                                strHomeYellowCards,
                                strLeague,
                                strSeason,
                                strSport,
                                strTime,
                                "",
                                ""
                            )
                        }
                    }
                    result?.let {
                        callback.onSuccess(it)
                    } ?: run {
                        callback.onError()
                    }
                } else {
                    callback.onError()
                }
            }

        })
    }

    fun searchEvent(text: String, callback: TheSportsDBRepositoryCallback) {
        api.searchEvent(text).enqueue(object : Callback<SearchEventsResponse> {
            override fun onFailure(call: Call<SearchEventsResponse>, t: Throwable) {
                callback.onError()
            }

            override fun onResponse(
                call: Call<SearchEventsResponse>,
                response: Response<SearchEventsResponse>
            ) {
                if (response.isSuccessful) {
                    val result = response.body()?.event
                        ?.filter { it -> it.strSport == "Soccer" }
                        ?.map {
                            with(it) {
                                EventItem(
                                    idEvent,
                                    idHomeTeam,
                                    idAwayTeam,
                                    strEvent,
                                    dateEvent,
                                    strTime,
                                    strHomeTeam,
                                    strAwayTeam,
                                    intHomeScore,
                                    intAwayScore,
                                    strThumb
                                )
                            }
                        }
                    result?.let {
                        callback.onSuccess(it)
                    } ?: run {
                        callback.onError()
                    }
                } else {
                    callback.onError()
                }
            }

        })
    }

    fun lookupTeam(id: Int, onSuccess: (LookupTeamItem) -> Unit, onError: (Throwable) -> Unit) {
        api.lookupTeam(id).enqueue(object : Callback<LookupTeamResponse> {
            override fun onFailure(call: Call<LookupTeamResponse>, t: Throwable) {
                onError(t)
            }

            override fun onResponse(
                call: Call<LookupTeamResponse>,
                response: Response<LookupTeamResponse>
            ) {
                if (response.isSuccessful) {
                    val result = response.body()?.teams?.map {
                        with(it) {
                            LookupTeamItem(
                                idLeague,
                                idSoccerXML,
                                idTeam,
                                intFormedYear,
                                intLoved,
                                intStadiumCapacity,
                                strAlternate,
                                strCountry,
                                strDescriptionCN,
                                strDescriptionDE,
                                strDescriptionEN,
                                strDescriptionES,
                                strDescriptionFR,
                                strDescriptionHU,
                                strDescriptionIL,
                                strDescriptionIT,
                                strDescriptionJP,
                                strDescriptionNL,
                                strDescriptionNO,
                                strDescriptionPL,
                                strDescriptionPT,
                                strDescriptionRU,
                                strDescriptionSE,
                                strDivision,
                                strFacebook,
                                strGender,
                                strInstagram,
                                strKeywords,
                                strLeague,
                                strLocked,
                                strManager,
                                strRSS,
                                strSport,
                                strStadium,
                                strStadiumDescription,
                                strStadiumLocation,
                                strStadiumThumb,
                                strTeam,
                                strTeamBadge,
                                strTeamBanner,
                                strTeamFanart1,
                                strTeamFanart2,
                                strTeamFanart3,
                                strTeamFanart4,
                                strTeamJersey,
                                strTeamLogo,
                                strTeamShort,
                                strTwitter,
                                strWebsite,
                                strYoutube
                            )
                        }
                    }
                    result?.let {
                        onSuccess(it[0])
                    } ?: run {
                        onError(Throwable("Data Empty!"))
                    }
                } else {
                    onError(Throwable("Something went wrong!"))
                }
            }

        })
    }

}