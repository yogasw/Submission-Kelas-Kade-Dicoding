/*
 * *
 *   Created by Yoga Setiawan on 12/11/19 10:22 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/10/19 9:22 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.arioki.submission.App
import com.arioki.submission.R
import com.arioki.submission.adapter.PagerAdapter
import com.arioki.submission.data.FootballItem
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_liga.*

class DetailLigaActivity : AppCompatActivity() {
    lateinit var data: FootballItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_detail_liga)
        data = intent.getParcelableExtra("FootballItem")
        initDetailLiga()
        initTab()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    fun getId(): Int {
        val id = data.id.toString()
        return id.toInt()
    }

    private fun initTab() {
        viewPagerDetailLiga.adapter =
            PagerAdapter(supportFragmentManager)
        tabsDetailLiga.setupWithViewPager(viewPagerDetailLiga)
    }

    private fun initDetailLiga() {
        shimerInfoLeague.startShimmerAnimation()
        App.instances.repository.leaguesLookup(getId(), {
            it.run {
                iv_str_league.text = strLeague
                iv_country.text = strCountry
                iv_date_first_event.text = dateFirstEvent
                iv_gender.text = strGender
                Picasso.get()
                    .load(strBadge)
                    .into(ivLogo, object : Callback {
                        override fun onSuccess() {
                            shimerInfoLeague.visibility = View.GONE
                            llInfoLeague.visibility = View.VISIBLE
                        }

                        override fun onError(e: Exception?) {
                            Log.d("LOGAPP", "error")
                        }
                    })
            }
        }, {
            it.printStackTrace()
        })

    }

}
