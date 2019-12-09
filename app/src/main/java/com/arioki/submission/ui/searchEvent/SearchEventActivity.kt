/*
 * *
 *   Created by Yoga Setiawan on 12/9/19 8:37 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 12/9/19 8:04 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.searchEvent

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.arioki.submission.App
import com.arioki.submission.R
import com.arioki.submission.adapter.EventAdapter
import com.arioki.submission.adapter.ListPlayersAdapter
import com.arioki.submission.adapter.ListTeamAdapter
import com.arioki.submission.data.EventItem
import com.arioki.submission.data.LookupAllPlayerItem
import com.arioki.submission.data.LookupAllTeamItem
import com.arioki.submission.ext.toaster
import com.arioki.submission.ui.detailEvent.DetailEventActivity
import com.arioki.submission.ui.detailPlayers.DetailPayersActivity
import com.arioki.submission.ui.detailTeam.DetailTeamActivity
import kotlinx.android.synthetic.main.activity_search.*


class SearchEventActivity : AppCompatActivity(),
    SearchEventView {
    override fun getTextSearch(): String = textSearch

    override fun dataEmpty() {
        shimmerSearch1.visibility = View.GONE
        shimmerSearch2.visibility = View.GONE
        rvSearch.visibility = View.GONE
        icEmpty.visibility = View.VISIBLE
    }

    override fun getSearchType(): String = spinner.selectedItem.toString()
    override fun searchError() {
        "Please Select Search Type".toaster(this)
    }

    override fun finishSearchTeam(lookupAllTeamItem: List<LookupAllTeamItem>) {
        val layoutManager = LinearLayoutManager(this)
        val adapter = ListTeamAdapter(this, lookupAllTeamItem) {
            val intent = Intent(this, DetailTeamActivity::class.java)
            intent.putExtra("dataTeam", it)
            startActivity(intent)
        }

        rvSearch.layoutManager = layoutManager
        rvSearch.adapter = adapter
    }

    override fun finishSearchPlayer(lookupAllPlayerItem: List<LookupAllPlayerItem>) {
        val layoutManager = LinearLayoutManager(this)
        val adapter = ListPlayersAdapter(this, lookupAllPlayerItem) {
            val intent = Intent(this, DetailPayersActivity::class.java)
            intent.putExtra("dataPlayer", it)
            startActivity(intent)
        }

        rvSearch.layoutManager = layoutManager
        rvSearch.adapter = adapter
    }

    override fun showShimmer() {
        shimmerSearch1.startShimmer()
        shimmerSearch2.startShimmer()
        icEmpty.visibility = View.GONE
        rvSearch.visibility = View.GONE
        shimmerSearch1.visibility = View.VISIBLE
        shimmerSearch2.visibility = View.VISIBLE
    }

    override fun finishSearchMatch(it: List<EventItem>) {
        val layoutManager = LinearLayoutManager(this)
        val adapter = EventAdapter(this, it, {
            val intent = Intent(this, DetailEventActivity::class.java)
            intent.putExtra("idEvent", it.id?.toInt())
            startActivity(intent)
        })
        rvSearch.layoutManager = layoutManager
        rvSearch.adapter = adapter

    }

    override fun hiddenSimmer() {
        shimmerSearch1.visibility = View.GONE
        shimmerSearch2.visibility = View.GONE
        rvSearch.visibility = View.VISIBLE
        icEmpty.visibility = View.GONE
    }

    private var eventPresenter: SearchEventPresenter? = null
    private var textSearch: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        initToolbar()
    }

    init {
        eventPresenter = SearchEventPresenter(this, App.instances.repository)
    }


    private fun initToolbar() {
        setSupportActionBar(toolbar)

        supportActionBar?.run {
            this.setDisplayHomeAsUpEnabled(true)
            this.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp)
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                spinner.selectedItem.toaster(applicationContext)
                eventPresenter?.searchData()
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                textSearch = newText
                return false
            }

        })
        val items = arrayOf("Select", "Team", "Match", "Player")
        val adapter = ArrayAdapter(this, R.layout.dropdown_item, items)
        spinner.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}



