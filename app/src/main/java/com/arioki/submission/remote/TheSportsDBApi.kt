/*
 * *
 *   Created by Yoga Setiawan on 12/8/19 11:31 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/28/19 6:04 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.remote

import com.arioki.submission.BuildConfig
import com.arioki.submission.remote.response.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object TheSportsDBApi {
    fun create(): Api {
        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
        return retrofit.create(Api::class.java)
    }

    interface Api {
        @GET("lookupleague.php")
        fun leaguesLookupResponse(@Query("id") id: Int): Call<LeaguesLookupResponse>

        @GET("eventsnextleague.php")
        fun leaguesNextEvent(@Query("id") id: Int): Call<NextEventResponse>

        @GET("eventspastleague.php")
        fun leaguesPastEvent(@Query("id") id: Int): Call<PastEventResponse>

        @GET("lookupEvent.php")
        fun lookupEvent(@Query("id") id: Int): Call<DetailEventResponse>

        @GET("lookupteam.php")
        fun lookupTeam(@Query("id") id: Int): Call<LookupTeamResponse>

        @GET("lookup_all_teams.php")
        fun lookupAllTeam(@Query("id") id: Int): Call<LookupAllTeamResponse>

        @GET("lookup_all_players.php")
        fun lookupAllPlayers(@Query("id") id: Int): Call<LookupAllPlayersResponse>

        @GET("searchevents.php")
        fun searchEvent(@Query("e") value: String): Call<SearchEventsResponse>

        @GET("searchteams.php")
        fun searchTeam(@Query("t") value: String): Call<LookupAllTeamResponse>

        @GET("searchplayers.php")
        fun searchPlayers(@Query("p") value: String): Call<LookupAllPlayersResponse>

        @GET("all_leagues.php")
        fun allLeagues(): Call<AllLeagueResponse>

        @GET("lookuptable.php")
        fun standingEvent(@Query("l") value: Int): Call<StandingsEventResponse>

    }
}