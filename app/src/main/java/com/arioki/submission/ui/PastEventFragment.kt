/*
 * *
 *   Created by Yoga Setiawan on 12/11/19 10:22 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/10/19 11:31 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui


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
import kotlinx.android.synthetic.main.fragment_past_event.*

/**
 * A simple [Fragment] subclass.
 */
class PastEventFragment : Fragment() {
    lateinit var adapter: EventAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutManager = LinearLayoutManager(context)
        val activity = activity as DetailLigaActivity
        val id = activity.getId()
        App.instances.repository.pastEvent(id, {
            hiddenSimmer()
            adapter = EventAdapter(context, it) {
                val intent = Intent(context, DetailEventActivity::class.java)
                intent.putExtra("idEvent", it.id?.toInt())
                startActivity(intent)
            }
            rvPastEvent.layoutManager = layoutManager
            rvPastEvent.adapter = adapter
        }, {
            hiddenSimmer()
        })
        return inflater.inflate(R.layout.fragment_past_event, container, false)
    }

    private fun hiddenSimmer() {
        shimmerPastEvent.visibility = View.GONE
        rvPastEvent.visibility = View.VISIBLE
    }

    override fun onResume() {
        super.onResume()
        shimmerPastEvent.startShimmerAnimation()
    }
}
