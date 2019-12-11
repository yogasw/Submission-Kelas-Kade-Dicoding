/*
 * *
 *   Created by Yoga Setiawan on 12/11/19 10:46 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/15/19 9:03 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.detailEvent

import android.database.sqlite.SQLiteConstraintException
import com.arioki.submission.data.DetailEventItem
import com.arioki.submission.data.DetailEventListItem
import com.arioki.submission.data.LookupTeamItem
import com.arioki.submission.db.Favorite
import com.arioki.submission.db.SportDBHelper
import com.arioki.submission.repository.DetailEventCallback
import com.arioki.submission.repository.LookupTeamRepositoryCallback
import com.arioki.submission.repository.TheSportsDBRepository
import org.jetbrains.anko.db.*

class DetailEventPresenter(
    var view: DetailEventView,
    var id: Int,
    private var repository: TheSportsDBRepository,
    private var database: SportDBHelper
) {
    fun getData() {
        //val showShimmer = view.showShimmer()
        val data = getDataFromDatabase()
        if (data.isNotEmpty()) {
            parsingData(data)
            view.showRemoveFavoriteButton()
        } else {
            view.showAddFavoriteButton()
            getDataFromApi()
        }
    }

    private fun parsingData(data: List<Map<String, Any?>>) {
        val result = data.map { columns ->
            DetailEventItem(
                columns["dateEvent"].toString(),
                columns["dateEventLocal"].toString(),
                columns["idAwayTeam"].toString(),
                columns["idEvent"].toString(),
                columns["idHomeTeam"].toString(),
                columns["intAwayScore"].toString(),
                columns["intAwayShots"].toString(),
                columns["intHomeScore"].toString(),
                columns["intHomeShots"].toString(),
                columns["intRound"].toString(),
                columns["intSpectators"].toString(),
                columns["strAwayFormation"].toString(),
                columns["strAwayGoalDetails"].toString(),
                columns["strAwayLineupDefense"].toString(),
                columns["strAwayLineupForward"].toString(),
                columns["strAwayLineupGoalkeeper"].toString(),
                columns["strAwayLineupMidfield"].toString(),
                columns["strAwayLineupSubstitutes"].toString(),
                columns["strAwayRedCards"].toString(),
                columns["strAwayTeam"].toString(),
                columns["strAwayYellowCards"].toString(),
                columns["strDate"].toString(),
                columns["strEvent"].toString(),
                columns["strEventAlternate"].toString(),
                columns["strFilename"].toString(),
                columns["strHomeFormation"].toString(),
                columns["strHomeGoalDetails"].toString(),
                columns["strHomeLineupDefense"].toString(),
                columns["strHomeLineupForward"].toString(),
                columns["strHomeLineupGoalkeeper"].toString(),
                columns["strHomeLineupMidfield"].toString(),
                columns["strHomeLineupSubstitutes"].toString(),
                columns["strHomeRedCards"].toString(),
                columns["strHomeTeam"].toString(),
                columns["strHomeYellowCards"].toString(),
                columns["strLeague"].toString(),
                columns["strSeason"].toString(),
                columns["strSport"].toString(),
                columns["strTime"].toString(),
                columns["strLogoHome"].toString(),
                columns["strLogoAway"].toString()
            )
        }
        view.finishLoadData(result[0])
    }

    fun getDataFromApi() {
        repository.detailEvent(this.id, object : DetailEventCallback {
            override fun onError() {
                view.hiddenShimmer()
            }

            override fun onSuccess(it: List<DetailEventItem>) {
                view.hiddenShimmer()
                view.finishLoadData(it[0])
            }

        })
    }

    private fun getDataFromDatabase(): List<Map<String, Any?>> {
        return database.use {
            select(Favorite.tbName)
                .whereArgs("idEvent == ${this@DetailEventPresenter.id}")
                .exec {
                    parseList(object : MapRowParser<Map<String, Any?>> {
                        override fun parseRow(columns: Map<String, Any?>): Map<String, Any?> {
                            return columns
                        }
                    }
                    )
                }
        }
    }

    fun getDataList(
        titles: Array<String>,
        detailEventItem: DetailEventItem
    ) {
        val items: MutableList<DetailEventListItem> = mutableListOf()
        detailEventItem.run {
            for (i in titles.indices) {
                items.add(
                    when (i) {
                        0 -> DetailEventListItem(intHomeScore, titles[i], intAwayScore)
                        1 -> DetailEventListItem(intHomeShots, titles[i], intAwayShots)
                        2 -> DetailEventListItem(strAwayRedCards, titles[i], strAwayRedCards)
                        3 -> DetailEventListItem(strHomeYellowCards, titles[i], strAwayYellowCards)
                        4 -> DetailEventListItem(strHomeFormation, titles[i], strAwayFormation)
                        5 -> DetailEventListItem(strHomeGoalDetails, titles[i], strAwayGoalDetails)
                        6 -> DetailEventListItem(
                            strHomeLineupDefense,
                            titles[i],
                            strAwayLineupDefense
                        )
                        7 -> DetailEventListItem(
                            strHomeLineupForward,
                            titles[i],
                            strAwayLineupForward
                        )
                        8 -> DetailEventListItem(
                            strHomeLineupGoalkeeper,
                            titles[i],
                            strAwayLineupGoalkeeper
                        )
                        9 -> DetailEventListItem(
                            strHomeLineupMidfield,
                            titles[i],
                            strAwayLineupMidfield
                        )
                        10 -> DetailEventListItem(
                            strHomeLineupSubstitutes,
                            titles[i],
                            strAwayLineupSubstitutes
                        )
                        else -> DetailEventListItem("-", "-", "-")
                    }
                )
            }
        }
        view.finishLoadDataList(items)
    }

    fun getUrlLogo(idHomeTeam: Int, team: String) {
        repository.lookupTeam(idHomeTeam, object : LookupTeamRepositoryCallback {
            override fun onError() {
            }

            override fun onSuccess(lookupTeamItem: LookupTeamItem) {
                val url: String = lookupTeamItem.strTeamBadge.toString()
                view.getUrlLogoDone(url, team)
            }
        })
    }

    fun insertFavorite(
        data: DetailEventItem,
        strLogoHome: String,
        strLogoAway: String
    ) {
        data.run {
            try {
                database.use {
                    insert(
                        Favorite.tbName,
                        Favorite.fdateEventLocal to dateEventLocal,
                        Favorite.fidAwayTeam to idAwayTeam,
                        Favorite.fidEvent to idEvent,
                        Favorite.fidHomeTeam to idHomeTeam,
                        Favorite.fintAwayScore to intAwayScore,
                        Favorite.fintAwayShots to intAwayShots,
                        Favorite.fintHomeScore to intHomeScore,
                        Favorite.fintHomeShots to intHomeShots,
                        Favorite.fintRound to intRound,
                        Favorite.fintSpectators to intSpectators,
                        Favorite.fstrAwayFormation to strAwayFormation,
                        Favorite.fstrAwayGoalDetails to strAwayGoalDetails,
                        Favorite.fstrAwayLineupDefense to strAwayLineupDefense,
                        Favorite.fstrAwayLineupForward to strAwayLineupForward,
                        Favorite.fstrAwayLineupGoalkeeper to strAwayLineupGoalkeeper,
                        Favorite.fstrAwayLineupMidfield to strAwayLineupMidfield,
                        Favorite.fstrAwayLineupSubstitutes to strAwayLineupSubstitutes,
                        Favorite.fstrAwayRedCards to strAwayRedCards,
                        Favorite.fstrAwayTeam to strAwayTeam,
                        Favorite.fstrAwayYellowCards to strAwayYellowCards,
                        Favorite.fstrDate to strDate,
                        Favorite.fstrEvent to strEvent,
                        Favorite.fstrEventAlternate to strEventAlternate,
                        Favorite.fstrFilename to strFilename,
                        Favorite.fstrHomeFormation to strHomeFormation,
                        Favorite.fstrHomeGoalDetails to strHomeGoalDetails,
                        Favorite.fstrHomeLineupDefense to strHomeLineupDefense,
                        Favorite.fstrHomeLineupForward to strHomeLineupForward,
                        Favorite.fstrHomeLineupGoalkeeper to strHomeLineupGoalkeeper,
                        Favorite.fstrHomeLineupMidfield to strHomeLineupMidfield,
                        Favorite.fstrHomeLineupSubstitutes to strHomeLineupSubstitutes,
                        Favorite.fstrHomeRedCards to strHomeRedCards,
                        Favorite.fstrHomeTeam to strHomeTeam,
                        Favorite.fstrHomeYellowCards to strHomeYellowCards,
                        Favorite.fstrLeague to strLeague,
                        Favorite.fstrSeason to strSeason,
                        Favorite.fstrSport to strSport,
                        Favorite.fstrTime to strTime,
                        Favorite.fstrLogoHome to strLogoHome,
                        Favorite.fstrLogoAway to strLogoAway
                    )
                }
                view.showRemoveFavoriteButton()
            } catch (e: SQLiteConstraintException) {
                e.printStackTrace()
            }
        }
    }

    fun removeFavorite(data: DetailEventItem) {
        data.run {
            try {
                database.use {
                    delete(
                        Favorite.tbName, "(${Favorite.fidEvent} = {id})",
                        "id" to data.idEvent.toString()
                    )
                }
                view.showAddFavoriteButton()
            } catch (e: SQLiteConstraintException) {
                e.printStackTrace()
            }
        }
    }


}
