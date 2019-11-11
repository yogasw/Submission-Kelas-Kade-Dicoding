package com.arioki.submission.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.arioki.submission.R
import com.arioki.submission.adapter.PagerAdapter
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
            FavoritePastEventFragment()
        )
        viewPagerFavorite.adapter = PagerAdapter(supportFragmentManager, pages)
        tabFavorite.setupWithViewPager(viewPagerFavorite)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
