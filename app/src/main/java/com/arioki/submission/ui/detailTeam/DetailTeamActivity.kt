/*
 * *
 *   Created by Yoga Setiawan on 11/24/19 7:48 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/24/19 7:47 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.detailTeam

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.arioki.submission.App
import com.arioki.submission.R
import com.arioki.submission.adapter.PagerAdapter
import com.arioki.submission.data.LookupAllTeamItem
import com.arioki.submission.ui.favoriteNextEvent.FavoriteNextEventFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_team.*

class DetailTeamActivity : AppCompatActivity(), DetailTeamView {
    lateinit var presenter: DetailTeamPresenter
    var data: LookupAllTeamItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        presenter = DetailTeamPresenter(this, App.instances.repository)
        val dataIntent = intent.getParcelableExtra<LookupAllTeamItem>("dataTeam")
        dataIntent?.let {
            iniDetailTeam(it)
            data = dataIntent
        }
    }

    private fun iniDetailTeam(data: LookupAllTeamItem) {
        Picasso.get()
            .load(data.strTeamBadge)
            .into(iv_logo_team)
        tv_team.text = data.strTeam
        tv_country.text = data.strCountry

        val pages = listOf(
            FavoriteNextEventFragment(),
            FavoriteNextEventFragment()
        )
        val title = listOf(
            "Team Info",
            "Players"
        )
        vp_detail_team.adapter = PagerAdapter(supportFragmentManager, pages, title)
        tl_detail_team.setupWithViewPager(vp_detail_team)
    }

    override fun getDataTeam() = data

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.favorite, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
