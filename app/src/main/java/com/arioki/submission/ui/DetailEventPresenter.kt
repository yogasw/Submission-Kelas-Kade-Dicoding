package com.arioki.submission.ui

import android.database.sqlite.SQLiteConstraintException
import com.arioki.submission.App
import com.arioki.submission.data.DetailEventItem
import com.arioki.submission.data.DetailEventListItem
import com.arioki.submission.db.Favorite
import org.jetbrains.anko.db.insert

class DetailEventPresenter(var id: Int) {
    var view: DetailEventView? = null
    fun attachView(view: DetailEventView) {
        this.view = view
    }

    fun getData() {
        view?.showAddFavoriteButton()
        view?.showShimmer()
        App.instances.repository.detailEvent(id, {
            view?.hiddenShimmer()
            view?.finishLoadData(it)
        }, {
            view?.hiddenShimmer()
        })
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
        view?.finishLoadDataList(items)
    }

    fun getUrlLogo(idHomeTeam: Int, team: String) {
        App.instances.repository.lookupTeam(idHomeTeam, {
            val url: String = it.strTeamBadge.toString()
            view?.getUrlLogoDone(url, team)
        }, {
        })
    }

    fun insertFavorite(
        data: DetailEventItem,
        strLogoHome: String,
        strLogoAway: String
    ) {
        data.run {
            try {
                App.instances.database.use {
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
                view?.showRemoveFavoriteButton()
            } catch (e: SQLiteConstraintException) {
            }
        }
    }


}