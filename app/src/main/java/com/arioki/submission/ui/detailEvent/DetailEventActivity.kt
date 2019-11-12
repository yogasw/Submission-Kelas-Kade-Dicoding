/*
 * *
 *   Created by Yoga Setiawan on 11/12/19 8:56 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/12/19 7:21 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.detailEvent

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.arioki.submission.R
import com.arioki.submission.adapter.DetailEventAdapter
import com.arioki.submission.data.DetailEventItem
import com.arioki.submission.data.DetailEventListItem
import com.arioki.submission.ext.logger
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_event.*


class DetailEventActivity : AppCompatActivity(),
    DetailEventView {
    lateinit var data: DetailEventItem
    private lateinit var strLogoHome: String
    private lateinit var strLogoAway: String
    private lateinit var menuButton: Menu
    private var favoriteMenu = 0
    override fun showAddFavoriteButton() {
        favoriteMenu = 1
        if (::menuButton.isInitialized) {
            menuButton.findItem(R.id.removeFavorites).isVisible = false
            menuButton.findItem(R.id.addFavorite).isVisible = true
        }
    }

    override fun showRemoveFavoriteButton() {
        favoriteMenu = 2
        if (::menuButton.isInitialized) {
            menuButton.findItem(R.id.removeFavorites).isVisible = true
            menuButton.findItem(R.id.addFavorite).isVisible = false
        }
    }

    override fun getUrlLogoDone(strTeamBadge: String, team: String) {
        if (team == "home") {
            strLogoHome = strTeamBadge
            Picasso.get()
                .load(strTeamBadge)
                .into(ivLogoHome, object : Callback {
                    override fun onSuccess() {
                        hiddenShimmer()
                    }

                    override fun onError(e: Exception?) {
                        "Error".logger()
                    }
                })
            Picasso.get()
                .load(strTeamBadge)
                .into(ivDetailHomeLogo, object : Callback {
                    override fun onSuccess() {
                        hiddenShimmer()
                    }

                    override fun onError(e: Exception?) {
                        "Error".logger()
                    }
                })
        } else if (team == "away") {
            strLogoAway = strTeamBadge
            Picasso.get()
                .load(strTeamBadge)
                .into(ivLogoAway, object : Callback {
                    override fun onSuccess() {
                        hiddenShimmer()
                    }

                    override fun onError(e: Exception?) {
                        "Error".logger()
                    }
                })

            Picasso.get()
                .load(strTeamBadge)
                .into(ivDetailAwayLogo, object : Callback {
                    override fun onSuccess() {
                        hiddenShimmer()
                    }

                    override fun onError(e: Exception?) {
                        "Error".logger()
                    }
                })
        }
    }


    override fun finishLoadDataList(items: MutableList<DetailEventListItem>) {
        val layoutManager = LinearLayoutManager(applicationContext)
        val adapter = DetailEventAdapter(applicationContext, items)
        rvDetailEvent.layoutManager = layoutManager
        //rvDetailEvent.isNestedScrollingEnabled = false
        rvDetailEvent.adapter = adapter
    }

    override fun finishLoadData(it: DetailEventItem) {
        it.logger()
        data = it
        it.run {
            val idHomeTeam = idHomeTeam?.toInt()
            val idAwayTeam = idAwayTeam?.toInt()

            if (strHomeTeam != "null") {
                tvDetailHomeName.text = strHomeTeam
            }

            if (strHomeTeam != "null") {
                tvHomeName.text = strHomeTeam
            }

            if (strAwayTeam != "null") {
                tvDetailAwayName.text = strAwayTeam
            }

            if (strAwayTeam != "null") {
                tvAwayName.text = strAwayTeam
            }

            if (intHomeScore != "null") {
                tvDetailHomeScore.text = intHomeScore
            }

            if (intAwayScore != "null") {
                tvDetailAwayScore.text = intAwayScore
            }

            if (strEvent != "null") {
                tvDetailNameEvent.text = strEvent
            }

            if (dateEvent != "null") {
                tvDateTime.text = dateEvent
            } else {
                tvDateTime.text = ""
            }

            if (idHomeTeam != null) {
                presenter.getUrlLogo(idHomeTeam, "home")
            }
            if (idAwayTeam != null) {
                presenter.getUrlLogo(idAwayTeam, "away")
            }

            val titles = resources.getStringArray(R.array.detailevent)
            presenter.getDataList(titles, this)
        }
    }

    override fun showShimmer() {
        shimmerLogoAwayDetail.startShimmer()
        shimmerLogoHomeyDetail.startShimmer()
        shimmerDateTime.startShimmer()
        shimmerDetailNameEvent.startShimmer()
        shimmerDetailEvent.startShimmer()
        shimmerConstraintLayout.startShimmer()
    }

    override fun hiddenShimmer() {
        shimmerLogoAwayDetail.visibility = View.GONE
        shimmerLogoHomeyDetail.visibility = View.GONE
        shimmerDateTime.visibility = View.GONE
        shimmerDetailNameEvent.visibility = View.GONE
        shimmerDetailEvent.visibility = View.GONE
        shimmerConstraintLayout.visibility = View.GONE
    }

    private lateinit var presenter: DetailEventPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_event)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        val id = intent.getIntExtra("idEvent", 0)
        presenter = DetailEventPresenter(id)
        presenter.attachView(this)
        presenter.getData()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
            R.id.addFavorite -> {
                if (::data.isInitialized && ::strLogoHome.isInitialized && ::strLogoAway.isInitialized) {
                    presenter.insertFavorite(data, strLogoHome, strLogoAway)
                }
            }
            R.id.removeFavorites -> {
                if (::data.isInitialized && ::strLogoHome.isInitialized && ::strLogoAway.isInitialized) {
                    presenter.removeFavorite(data)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (menu != null) {
            this.menuButton = menu

        }
        menuInflater.inflate(R.menu.favorite, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if (favoriteMenu == 1) {
            menu?.findItem(R.id.removeFavorites)?.isVisible = false
            menu?.findItem(R.id.addFavorite)?.isVisible = true
        } else {
            menu?.findItem(R.id.removeFavorites)?.isVisible = true
            menu?.findItem(R.id.addFavorite)?.isVisible = false
        }
        return super.onPrepareOptionsMenu(menu)
    }
}
