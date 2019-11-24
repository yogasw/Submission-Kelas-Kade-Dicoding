/*
 * *
 *   Created by Yoga Setiawan on 11/24/19 7:48 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/24/19 6:54 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.detailTeam

import com.arioki.submission.data.LookupAllTeamItem

interface DetailTeamView {
    fun getDataTeam(): LookupAllTeamItem?
}
