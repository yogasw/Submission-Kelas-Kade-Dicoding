package com.arioki.submission.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class SportDBHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "FavoriteEvent.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(
            Favorite.tbName, true,
            Favorite.fdateEventLocal to TEXT,
            Favorite.fidAwayTeam to TEXT,
            Favorite.fidEvent to TEXT + PRIMARY_KEY,
            Favorite.fidHomeTeam to TEXT,
            Favorite.fintAwayScore to TEXT,
            Favorite.fintAwayShots to TEXT,
            Favorite.fintHomeScore to TEXT,
            Favorite.fintHomeShots to TEXT,
            Favorite.fintRound to TEXT,
            Favorite.fintSpectators to TEXT,
            Favorite.fstrAwayFormation to TEXT,
            Favorite.fstrAwayGoalDetails to TEXT,
            Favorite.fstrAwayLineupDefense to TEXT,
            Favorite.fstrAwayLineupForward to TEXT,
            Favorite.fstrAwayLineupGoalkeeper to TEXT,
            Favorite.fstrAwayLineupMidfield to TEXT,
            Favorite.fstrAwayLineupSubstitutes to TEXT,
            Favorite.fstrAwayRedCards to TEXT,
            Favorite.fstrAwayTeam to TEXT,
            Favorite.fstrAwayYellowCards to TEXT,
            Favorite.fstrDate to TEXT,
            Favorite.fstrEvent to TEXT,
            Favorite.fstrEventAlternate to TEXT,
            Favorite.fstrFilename to TEXT,
            Favorite.fstrHomeFormation to TEXT,
            Favorite.fstrHomeGoalDetails to TEXT,
            Favorite.fstrHomeLineupDefense to TEXT,
            Favorite.fstrHomeLineupForward to TEXT,
            Favorite.fstrHomeLineupGoalkeeper to TEXT,
            Favorite.fstrHomeLineupMidfield to TEXT,
            Favorite.fstrHomeLineupSubstitutes to TEXT,
            Favorite.fstrHomeRedCards to TEXT,
            Favorite.fstrHomeTeam to TEXT,
            Favorite.fstrHomeYellowCards to TEXT,
            Favorite.fstrLeague to TEXT,
            Favorite.fstrSeason to TEXT,
            Favorite.fstrSport to TEXT,
            Favorite.fstrTime to TEXT,
            Favorite.fstrLogoHome to TEXT,
            Favorite.fstrLogoAway to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(Favorite.tbName, true)
    }

    companion object {
        private var instance: SportDBHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): SportDBHelper {
            if (instance == null) {
                instance = SportDBHelper(ctx.applicationContext)
            }
            return instance as SportDBHelper
        }
    }
}