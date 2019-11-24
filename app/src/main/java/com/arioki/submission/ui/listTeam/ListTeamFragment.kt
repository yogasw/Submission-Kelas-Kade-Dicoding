/*
 * *
 *   Created by Yoga Setiawan on 11/24/19 7:48 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/24/19 4:41 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.listTeam


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
import com.arioki.submission.ui.detailLiga.DetailLigaActivity
import com.arioki.submission.ui.detailTeam.DetailTeamActivity
import kotlinx.android.synthetic.main.fragment_list_team.*

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
        rv_list_team.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_list_team.adapter = adapter
    }
}
