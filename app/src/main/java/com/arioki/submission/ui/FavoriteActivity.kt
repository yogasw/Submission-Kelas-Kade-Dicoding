/*
 * *
 *   Created by Yoga Setiawan on 12/8/19 11:26 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 12/8/19 8:53 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.arioki.submission.R
import com.arioki.submission.adapter.PagerAdapter
import com.arioki.submission.ui.favoriteNextEvent.FavoriteNextEventFragment
import com.arioki.submission.ui.favoritePastEvent.FavoritePastEventFragment
import com.arioki.submission.ui.favoriteTeam.FavoriteTeamFragment
import kotlinx.android.synthetic.main.activity_favorite.*


class FavoriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initTab()
    }

    private fun initTab() {
        val pages = listOf(
            FavoriteNextEventFragment(),
            FavoritePastEventFragment(),
            FavoriteTeamFragment()
        )
        val title = listOf(
            "Next Match",
            "Last Match",
            "Team"
        )
        viewPagerFavorite.adapter = PagerAdapter(supportFragmentManager, pages, title)
        tabFavorite.setupWithViewPager(viewPagerFavorite)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }


}
