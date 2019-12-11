/*
 * *
 *   Created by Yoga Setiawan on 12/11/19 10:22 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/10/19 11:31 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui

import com.arioki.submission.App
import com.arioki.submission.data.DetailEventItem
import com.arioki.submission.data.DetailEventListItem

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