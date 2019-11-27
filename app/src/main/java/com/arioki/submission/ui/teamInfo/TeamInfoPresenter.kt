/*
 * *
 *   Created by Yoga Setiawan on 11/27/19 9:31 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/27/19 9:11 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.teamInfo

import com.arioki.submission.data.LookupAllTeamItem
import com.arioki.submission.data.TeamInfoItem
import com.arioki.submission.repository.TheSportsDBRepository

class TeamInfoPresenter(
    val view: TeamInfoView,
    val repository: TheSportsDBRepository
) {
    fun getData(dataTeam: LookupAllTeamItem?, titles: Array<String>) {
        val items: MutableList<TeamInfoItem> = mutableListOf()
        for (i in titles.indices) {
            when (i) {
                0 -> items.add(TeamInfoItem(titles[i], dataTeam?.idTeam))
                1 -> items.add(TeamInfoItem(titles[i], dataTeam?.strTeam))
                2 -> items.add(TeamInfoItem(titles[i], dataTeam?.strTeamShort))
                3 -> items.add(TeamInfoItem(titles[i], dataTeam?.strAlternate))
                4 -> items.add(TeamInfoItem(titles[i], dataTeam?.intFormedYear))
                5 -> items.add(TeamInfoItem(titles[i], dataTeam?.strSport))
                6 -> items.add(TeamInfoItem(titles[i], dataTeam?.strLeague))
                7 -> items.add(TeamInfoItem(titles[i], dataTeam?.idLeague))
                8 -> items.add(TeamInfoItem(titles[i], dataTeam?.strDivision))
                9 -> items.add(TeamInfoItem(titles[i], dataTeam?.strManager))
                10 -> items.add(TeamInfoItem(titles[i], dataTeam?.strStadium))
                11 -> items.add(TeamInfoItem(titles[i], dataTeam?.strKeywords))
                12 -> items.add(TeamInfoItem(titles[i], dataTeam?.strStadiumLocation))
                13 -> items.add(TeamInfoItem(titles[i], dataTeam?.intStadiumCapacity))
                14 -> items.add(TeamInfoItem(titles[i], dataTeam?.strWebsite))
                15 -> items.add(TeamInfoItem(titles[i], dataTeam?.strFacebook))
                16 -> items.add(TeamInfoItem(titles[i], dataTeam?.strTwitter))
                17 -> items.add(TeamInfoItem(titles[i], dataTeam?.strInstagram))
                18 -> items.add(TeamInfoItem(titles[i], dataTeam?.strYoutube))
                19 -> items.add(TeamInfoItem(titles[i], dataTeam?.strRSS))
                20 -> items.add(TeamInfoItem(titles[i], dataTeam?.strGender))
                21 -> items.add(TeamInfoItem(titles[i], dataTeam?.strCountry))
                22 -> items.add(TeamInfoItem(titles[i], dataTeam?.strLocked))
                23 -> items.add(TeamInfoItem(titles[i], dataTeam?.strDescriptionEN))
            }
        }
        view.getDataFinish(items)
    }


}
