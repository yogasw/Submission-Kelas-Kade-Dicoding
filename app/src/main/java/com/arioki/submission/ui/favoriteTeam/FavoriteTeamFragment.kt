/*
 * *
 *   Created by Yoga Setiawan on 12/9/19 9:21 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 12/9/19 9:06 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.favoriteTeam


import android.content.Intent
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
import com.arioki.submission.ui.detailTeam.DetailTeamActivity
import kotlinx.android.synthetic.main.fragment_favorit_team.*

class FavoriteTeamFragment : Fragment(), FavoriteTeamView {
    lateinit var presenter: FavoriteTeamPresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorit_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = FavoriteTeamPresenter(this, App.instances.repository, App.instances.database)
        presenter.getData()
    }

    override fun getDataDone(result: List<LookupAllTeamItem>) {
        val adapter = ListTeamAdapter(context, result) {
            val intent = Intent(context, DetailTeamActivity::class.java)
            val data = with(it) {
                LookupAllTeamItem(
                    idLeague,
                    idSoccerXML,
                    idTeam,
                    intFormedYear,
                    intLoved,
                    intStadiumCapacity,
                    strAlternate,
                    strCountry,
                    strDescriptionCN,
                    strDescriptionDE,
                    strDescriptionEN,
                    strDescriptionES,
                    strDescriptionFR,
                    strDescriptionHU,
                    strDescriptionIL,
                    strDescriptionIT,
                    strDescriptionJP,
                    strDescriptionNL,
                    strDescriptionNO,
                    strDescriptionPL,
                    strDescriptionPT,
                    strDescriptionRU,
                    strDescriptionSE,
                    strDivision,
                    strFacebook,
                    strGender,
                    strInstagram,
                    strKeywords,
                    strLeague,
                    strLocked,
                    strManager,
                    strRSS,
                    strSport,
                    strStadium,
                    strStadiumDescription,
                    strStadiumLocation,
                    strStadiumThumb,
                    strTeam,
                    strTeamBadge,
                    strTeamBanner,
                    strTeamFanart1,
                    strTeamFanart2,
                    strTeamFanart3,
                    strTeamFanart4,
                    strTeamJersey,
                    strTeamLogo,
                    strTeamShort,
                    strTwitter,
                    strWebsite,
                    strYoutube
                )
            }
            intent.putExtra("dataTeam", data)
            startActivity(intent)
        }
        rv_favorite_team.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_favorite_team.adapter = adapter
    }


}
