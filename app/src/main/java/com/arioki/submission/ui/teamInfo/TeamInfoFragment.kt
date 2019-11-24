/*
 * *
 *   Created by Yoga Setiawan on 11/25/19 5:57 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/25/19 5:57 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.teamInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.arioki.submission.App
import com.arioki.submission.R
import com.arioki.submission.adapter.TeamInfoAdapter
import com.arioki.submission.data.TeamInfoItem
import com.arioki.submission.ui.detailTeam.DetailTeamActivity
import kotlinx.android.synthetic.main.fragment_team_info.*


class TeamInfoFragment : Fragment(), TeamInfoView {
    lateinit var infoAdapter: TeamInfoAdapter
    lateinit var infoItems: List<TeamInfoItem>
    lateinit var presenter: TeamInfoPresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = TeamInfoPresenter(this, App.instances.repository)
        val activity = activity as DetailTeamActivity
        presenter.getData(activity.getDataTeam())
    }

    private fun initRv() {
        context?.let {
            infoAdapter = TeamInfoAdapter(it, infoItems)
            rv_team_info.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            rv_team_info.adapter = infoAdapter
        }

    }
}
