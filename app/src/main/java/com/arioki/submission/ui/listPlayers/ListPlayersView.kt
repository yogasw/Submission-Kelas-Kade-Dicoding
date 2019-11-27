/*
 * *
 *   Created by Yoga Setiawan on 11/27/19 9:31 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/27/19 9:31 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.listPlayers

import com.arioki.submission.data.LookupAllPlayerItem

interface ListPlayersView {
    fun getDataPlayersError(t: Throwable)
    fun getDataPlayersSuccess(lookupAllPlayerItem: List<LookupAllPlayerItem>)

}
