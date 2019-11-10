package com.arioki.submission1.ui

import com.arioki.submission1.App
import com.arioki.submission1.data.DetailEventItem
import com.arioki.submission1.data.DetailEventListItem

class DetailEventPresenter(var id: Int) {
    var view: DetailEventView? = null
    fun attachView(view: DetailEventView) {
        this.view = view
    }

    fun getData() {
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


}