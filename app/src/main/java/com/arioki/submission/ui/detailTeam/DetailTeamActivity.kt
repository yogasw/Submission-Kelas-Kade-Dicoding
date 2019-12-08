/*
 * *
 *   Created by Yoga Setiawan on 12/8/19 11:26 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 12/8/19 11:25 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.detailTeam

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.arioki.submission.App
import com.arioki.submission.R
import com.arioki.submission.adapter.PagerAdapter
import com.arioki.submission.data.LookupAllTeamItem
import com.arioki.submission.ui.listPlayers.ListPlayersFragment
import com.arioki.submission.ui.teamInfo.TeamInfoFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_team.*

class DetailTeamActivity : AppCompatActivity(), DetailTeamView {
    lateinit var presenter: DetailTeamPresenter
    var data: LookupAllTeamItem? = null
    private var favoriteMenu = 1
    lateinit var menuButton: Menu
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val dataIntent = intent.getParcelableExtra<LookupAllTeamItem>("dataTeam")
        dataIntent?.let {
            iniDetailTeam(it)
            data = dataIntent
        }
        presenter = DetailTeamPresenter(
            this,
            App.instances.repository,
            App.instances.database,
            getDataTeam()
        )
        presenter.checkData()
    }

    private fun iniDetailTeam(data: LookupAllTeamItem) {
        Picasso.get()
            .load(data.strTeamBadge + "/preview")
            .into(iv_logo_team)
        tv_team.text = data.strTeam
        tv_country.text = data.strCountry

        val pages = listOf(
            TeamInfoFragment(),
            ListPlayersFragment()
        )
        val title = listOf(
            "Team Info",
            "Players"
        )
        vp_detail_team.adapter = PagerAdapter(supportFragmentManager, pages, title)
        tl_detail_team.setupWithViewPager(vp_detail_team)
    }

    override fun getDataTeam() = data
    override fun showRemoveFavoriteButton() {
        favoriteMenu = 2
        if (::menuButton.isInitialized) {
            menuButton.findItem(R.id.removeFavorites).isVisible = true
            menuButton.findItem(R.id.addFavorite).isVisible = false
        }
    }

    override fun showAddFavoriteButton() {
        favoriteMenu = 1
        if (::menuButton.isInitialized) {
            menuButton.findItem(R.id.removeFavorites).isVisible = false
            menuButton.findItem(R.id.addFavorite).isVisible = true
        }
    }

    override fun checkDataFinish(count: Int) {
        if (count > 0) {
            showRemoveFavoriteButton()
        } else {
            showAddFavoriteButton()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.favorite, menu)
        if (menu != null) {
            menuButton = menu
        }
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
            R.id.addFavorite -> presenter.addFavoriteItem()
            R.id.removeFavorites -> presenter.removeFavoriteItem()
        }
        return super.onOptionsItemSelected(item)
    }

}
