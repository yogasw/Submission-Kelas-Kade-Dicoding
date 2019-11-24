/*
 * *
 *   Created by Yoga Setiawan on 11/24/19 1:54 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/24/19 10:57 AM
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

        @GET("searchevents.php")
        fun searchEvent(@Query("e") text: String): Call<SearchEventsResponse>

        @GET("lookupteam.php")
        fun lookupTeam(@Query("id") id: Int): Call<LookupTeamResponse>

        @GET("lookup_all_teams.php")
        fun lookupAllTeam(@Query("id") id: Int): Call<LookupAllTeam>
    }
}