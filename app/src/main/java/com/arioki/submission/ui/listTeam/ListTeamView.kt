/*
 * *
 *   Created by Yoga Setiawan on 11/24/19 1:54 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/24/19 1:52 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.listTeam

import com.arioki.submission.data.LookupAllTeamItem

interface ListTeamView {
    fun getDataError(t: Throwable)
    fun getDataSuccess(lookupAllTeamItem: List<LookupAllTeamItem>)

}
