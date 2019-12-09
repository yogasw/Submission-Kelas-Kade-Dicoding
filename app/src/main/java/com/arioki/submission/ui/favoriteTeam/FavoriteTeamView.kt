/*
 * *
 *   Created by Yoga Setiawan on 12/9/19 9:21 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 12/9/19 8:58 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.favoriteTeam

import com.arioki.submission.data.LookupAllTeamItem

interface FavoriteTeamView {
    fun getDataDone(result: List<LookupAllTeamItem>)
}
