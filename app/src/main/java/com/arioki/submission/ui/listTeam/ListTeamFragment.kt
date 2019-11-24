/*
 * *
 *   Created by Yoga Setiawan on 11/24/19 1:54 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/24/19 1:52 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.listTeam


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.arioki.submission.App
import com.arioki.submission.R
import com.arioki.submission.adapter.ListTeamAdapter
import com.arioki.submission.data.LookupAllTeamItem
import com.arioki.submission.ui.detailLiga.DetailLigaActivity
import kotlinx.android.synthetic.main.fragment_list_team.*

/**
 * A simple [Fragment] subclass.
 */
class ListTeamFragment : Fragment(), ListTeamView {
    lateinit var presenter: ListTeamPresenter
    lateinit var adapter: ListTeamAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = activity as DetailLigaActivity
        presenter = ListTeamPresenter(this, activity.getId(), App.instances.repository)
        presenter.getData()
    }

    override fun getDataError(t: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDataSuccess(lookupAllTeamItem: List<LookupAllTeamItem>) {
        adapter = ListTeamAdapter(context, lookupAllTeamItem) {
            /*  val intent = Intent(context, DetailEventActivity::class.java)
              intent.putExtra("idEvent", it.str)
              startActivity(intent)*/
        }
        rv_list_team.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_list_team.adapter = adapter
    }
}
