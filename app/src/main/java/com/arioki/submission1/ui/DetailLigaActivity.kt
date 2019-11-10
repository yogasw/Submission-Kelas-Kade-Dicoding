package com.arioki.submission1.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.arioki.submission1.App
import com.arioki.submission1.R
import com.arioki.submission1.adapter.PagerAdapter
import com.arioki.submission1.data.FootballItem
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_liga.*

class DetailLigaActivity : AppCompatActivity() {
    lateinit var data: FootballItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_liga)
        data = intent.getParcelableExtra("FootballItem")
        initDetailLiga()
        initTab()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.btnMenuSearch) {
            Toast.makeText(applicationContext, "setting", Toast.LENGTH_LONG).show()
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
