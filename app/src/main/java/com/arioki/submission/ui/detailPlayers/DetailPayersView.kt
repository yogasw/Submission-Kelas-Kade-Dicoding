/*
 * *
 *   Created by Yoga Setiawan on 11/27/19 9:31 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/26/19 11:15 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.detailPlayers

import com.arioki.submission.data.TeamInfoItem

interface DetailPayersView {
    fun getDataFinish(items: List<TeamInfoItem>)

}
