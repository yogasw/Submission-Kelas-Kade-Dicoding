/*
 * *
 *   Created by Yoga Setiawan on 11/27/19 9:31 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/27/19 8:59 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.detailPlayers

import com.arioki.submission.data.LookupAllPlayerItem
import com.arioki.submission.data.TeamInfoItem

class DetailPayersPresenter(var view: DetailPayersView) {
    fun loadData(dataPlayer: LookupAllPlayerItem, playerInfo: Array<String>) {
        val items: MutableList<TeamInfoItem> = mutableListOf()
        dataPlayer.run {
            for (i in playerInfo.indices) {
                when (i) {
                    0 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.strNationality))
                    1 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.strPlayer))
                    2 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.strTeam))
                    3 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.strTeam2))
                    4 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.strSport))
                    5 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.dateBorn))
                    6 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.strNumber))
                    7 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.dateSigned))
                    8 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.strSigning))
                    9 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.strWage))
                    10 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.strOutfitter))
                    11 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.strKit))
                    12 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.strAgent))
                    13 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.strBirthLocation))
                    14 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.strDescriptionEN))
                    15 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.strGender))
                    16 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.strSide))
                    17 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.strPosition))
                    18 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.strCollege))
                    19 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.strFacebook))
                    20 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.strWebsite))
                    21 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.strTwitter))
                    22 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.strInstagram))
                    23 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.strYoutube))
                    24 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.strHeight))
                    25 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.strWeight))
                    26 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.intLoved))
                    27 -> items.add(TeamInfoItem(playerInfo[i], dataPlayer.strLocked))
                }
            }
        }
        view.getDataFinish(items)
    }

}
