/*
 * *
 *   Created by Yoga Setiawan on 11/27/19 10:42 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/27/19 10:32 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.listPlayers


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.arioki.submission.App
import com.arioki.submission.R
import com.arioki.submission.adapter.ListPlayersAdapter
import com.arioki.submission.data.LookupAllPlayerItem
import com.arioki.submission.ui.detailPlayers.DetailPayersActivity
import com.arioki.submission.ui.detailTeam.DetailTeamActivity
import kotlinx.android.synthetic.main.fragment_list_players.*

/**
 * A simple [Fragment] subclass.
 */
class ListPlayersFragment : Fragment(), ListPlayersView {
    lateinit var presenter: ListPlayersPresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_players, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = activity as DetailTeamActivity
        presenter = ListPlayersPresenter(this, activity.getDataTeam(), App.instances.repository)
        presenter.getDataPlayers()

    }

    override fun getDataPlayersError(t: Throwable) {}

    override fun getDataPlayersSuccess(lookupAllPlayerItem: List<LookupAllPlayerItem>) {

        rv_team_players.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_team_players.adapter = ListPlayersAdapter(context, lookupAllPlayerItem) {
            val intent = Intent(context, DetailPayersActivity::class.java)
            intent.putExtra("dataPlayer", it)
            startActivity(intent)
        }
    }


}
