/*
 * *
 *   Created by Yoga Setiawan on 12/11/19 10:46 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/15/19 3:02 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.searchEvent

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.arioki.submission.App
import com.arioki.submission.R
import com.arioki.submission.adapter.EventAdapter
import com.arioki.submission.data.EventItem
import com.arioki.submission.ui.detailEvent.DetailEventActivity
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

    override fun showShimmer() {
        shimmerSearch1.startShimmer()
        shimmerSearch2.startShimmer()
        icEmpty.visibility = View.GONE
        rvSearch.visibility = View.GONE
        shimmerSearch1.visibility = View.VISIBLE
        shimmerSearch2.visibility = View.VISIBLE
    }

    lateinit var adapter: EventAdapter
    override fun finishLoadData(it: List<EventItem>) {
        val layoutManager = LinearLayoutManager(this)
        adapter = EventAdapter(this, it) {
            val intent = Intent(this, DetailEventActivity::class.java)
            intent.putExtra("idEvent", it.id?.toInt())
            startActivity(intent)
        }
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
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                eventPresenter?.searchData()
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                textSearch = newText
                return false
            }

        })
    }
}



