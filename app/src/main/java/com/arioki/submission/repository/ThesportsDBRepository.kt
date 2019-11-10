package com.arioki.submission.repository

import com.arioki.submission.data.DetailEventItem
import com.arioki.submission.data.EventItem
import com.arioki.submission.data.LeaguesItem
import com.arioki.submission.remote.ThesportsDBApi
import com.arioki.submission.remote.response.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ThesportsDBRepository(val api: ThesportsDBApi.Api) {

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
                    var result = response.body()?.leagues?.map {
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

    fun detailEvent(
        id: Int,
        onSuccess: (DetailEventItem) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        api.lookupEvent(id).enqueue(object : Callback<DetailEventResponse> {
            override fun onFailure(call: Call<DetailEventResponse>, t: Throwable) {
                onError(t)
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
                                strTime
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

    fun searchEvent(
        text: String,
        onSuccess: (List<EventItem>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        api.searchEvent(text).enqueue(object : Callback<SearchEventsResponse> {
            override fun onFailure(call: Call<SearchEventsResponse>, t: Throwable) {
                onError(t)
            }

            override fun onResponse(
                call: Call<SearchEventsResponse>,
                response: Response<SearchEventsResponse>
            ) {
                if (response.isSuccessful) {
                    val result = response.body()?.event?.map {
                        with(it) {
                            EventItem(
                                idEvent,
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

}