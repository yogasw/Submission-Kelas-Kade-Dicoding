package com.arioki.submission1.remote

import com.arioki.submission1.BuildConfig
import com.arioki.submission1.remote.response.DetailEventResponse
import com.arioki.submission1.remote.response.LeaguesLookupResponse
import com.arioki.submission1.remote.response.NextEventResponse
import com.arioki.submission1.remote.response.PastEventResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object ThesportsDBApi {
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

        @GET("lookupevent.php")
        fun lookupevent(@Query("id") id: Int): Call<DetailEventResponse>

    }
}