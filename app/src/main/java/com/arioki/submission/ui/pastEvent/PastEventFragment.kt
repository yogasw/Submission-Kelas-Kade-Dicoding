/*
 * *
 *   Created by Yoga Setiawan on 12/9/19 8:37 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 12/9/19 8:37 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.pastEvent

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.arioki.submission.App
import com.arioki.submission.R
import com.arioki.submission.adapter.EventAdapter
import com.arioki.submission.data.EventItem
import com.arioki.submission.ui.detailEvent.DetailEventActivity
import com.arioki.submission.ui.detailLiga.DetailLigaActivity
import kotlinx.android.synthetic.main.fragment_past_event.*

class PastEventFragment : Fragment(), PastEventView {
    private lateinit var adapter: EventAdapter
    private lateinit var presenter: PastEventPresenter
    private var id: Int? = 0
    private lateinit var layoutManager: LinearLayoutManager

    override fun getDataDone(it: List<EventItem>) {
        adapter = EventAdapter(context, it, {
            val intent = Intent(context, DetailEventActivity::class.java)
            intent.putExtra("idEvent", it.id?.toInt())
            startActivity(intent)
        }, false)
        rvPastEvent.layoutManager = layoutManager
        rvPastEvent.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_past_event, container, false)
    }

    override fun hiddenSimmer() {
        shimmerPastEvent.visibility = View.GONE
        rvPastEvent.visibility = View.VISIBLE
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = activity as DetailLigaActivity
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        id = activity.getId()
        presenter = PastEventPresenter(this, id!!, App.instances.repository)
        presenter.getData()
    }

    override fun onResume() {
        super.onResume()
        shimmerPastEvent.startShimmer()
    }
}
