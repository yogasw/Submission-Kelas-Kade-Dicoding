package com.arioki.submission.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arioki.submission.R
import com.arioki.submission.adapter.PagerAdapter
import kotlinx.android.synthetic.main.activity_favorite.*


class FavoriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)
        //initTab()
    }

    private fun initTab() {
        viewPagerFavorite.adapter = PagerAdapter(supportFragmentManager)
        tabFavorite.setupWithViewPager(viewPagerFavorite)
    }
}
