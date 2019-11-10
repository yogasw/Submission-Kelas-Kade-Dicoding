package com.arioki.submission1.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.arioki.submission1.R
import com.arioki.submission1.adapter.DetailEventAdapter
import com.arioki.submission1.data.DetailEventItem
import com.arioki.submission1.data.DetailEventListItem
import com.arioki.submission1.ext.logger
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_event.*

class DetailEventActivity : AppCompatActivity(), DetailEventView {
    override fun finishLoadData(it: DetailEventItem) {
        it.logger(this)
        it.run {
            tvDetailHomeName.text = strHomeTeam
            tvHomeName.text = strHomeTeam

            tvDetailAwayName.text = strAwayTeam
            tvAwayName.text = strAwayTeam

            tvDetailHomeScore.text = intHomeScore
            tvDetailAwayScore.text = intAwayScore

            tvDetailNameEvent.text = strEvent
            tvDateTime.text = dateEvent

            Picasso.get()
                .load("https://www.thesportsdb.com/images/media/team/badge/a1af2i1557005128.png")
                .into(ivLogoHome, object : Callback {
                    override fun onSuccess() {
                        hiddenShimmer()
                    }

                    override fun onError(e: Exception?) {
                        "Error".logger(applicationContext)
                    }
                })

            Picasso.get()
                .load("https://www.thesportsdb.com/images/media/team/badge/a1af2i1557005128.png")
                .into(ivLogoAway, object : Callback {
                    override fun onSuccess() {
                        hiddenShimmer()
                    }

                    override fun onError(e: Exception?) {
                        "Error".logger(applicationContext)
                    }
                })

            Picasso.get()
                .load("https://www.thesportsdb.com/images/media/team/badge/a1af2i1557005128.png")
                .into(ivDetailHomeLogo, object : Callback {
                    override fun onSuccess() {
                        hiddenShimmer()
                    }

                    override fun onError(e: Exception?) {
                        "Error".logger(applicationContext)
                    }
                })
            Picasso.get()
                .load("https://www.thesportsdb.com/images/media/team/badge/a1af2i1557005128.png")
                .into(ivDetailAwayLogo, object : Callback {
                    override fun onSuccess() {
                        hiddenShimmer()
                    }

                    override fun onError(e: Exception?) {
                        "Error".logger(applicationContext)
                    }
                })

            val layoutManager = LinearLayoutManager(applicationContext)

            val titles = resources.getStringArray(R.array.detailevent)
            val items: MutableList<DetailEventListItem> = mutableListOf()
            items.clear()
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
            val adapter = DetailEventAdapter(applicationContext, items)
            rvDetailEvent.layoutManager = layoutManager
            rvDetailEvent.isNestedScrollingEnabled = false
            rvDetailEvent.adapter = adapter

        }

    }

    override fun showShimmer() {

    }

    override fun hiddenShimmer() {

    }

    private lateinit var presenter: DetailEventPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_event)
        val id = intent.getIntExtra("idEvent", 0)
        presenter = DetailEventPresenter(id)
        presenter.attachView(this)
        presenter.getData()
    }
}
