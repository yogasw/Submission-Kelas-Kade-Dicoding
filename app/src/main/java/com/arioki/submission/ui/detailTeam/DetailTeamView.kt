/*
 * *
 *   Created by Yoga Setiawan on 12/8/19 11:26 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 12/8/19 11:21 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.detailTeam

import com.arioki.submission.data.LookupAllTeamItem

interface DetailTeamView {
    fun getDataTeam(): LookupAllTeamItem?
    fun showRemoveFavoriteButton()
    fun showAddFavoriteButton()
    fun checkDataFinish(count: Int)
}
