/*
 * *
 *   Created by Yoga Setiawan on 11/27/19 9:31 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/27/19 10:03 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.detailPlayers

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.arioki.submission.R
import com.arioki.submission.adapter.TeamInfoAdapter
import com.arioki.submission.data.LookupAllPlayerItem
import com.arioki.submission.data.TeamInfoItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_payers.*

class DetailPayersActivity : AppCompatActivity(), DetailPayersView {
    private var dataPlayer: LookupAllPlayerItem? = null
    lateinit var presenter: DetailPayersPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_payers)
        presenter = DetailPayersPresenter(this)
        dataPlayer = intent.getParcelableExtra("dataPlayer")
        initData(dataPlayer)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initData(dataPlayer: LookupAllPlayerItem?) {
        dataPlayer?.run {
            Picasso.get()
                .load(strCutout)
                .into(circle_Image)
            tv_title.text = strPlayer
            tv_team.text = strTeam
            presenter.loadData(dataPlayer, resources.getStringArray(R.array.player_info))
        }

    }

    override fun getDataFinish(items: List<TeamInfoItem>) {
        rv_detail.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_detail.adapter = TeamInfoAdapter(this, items)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
