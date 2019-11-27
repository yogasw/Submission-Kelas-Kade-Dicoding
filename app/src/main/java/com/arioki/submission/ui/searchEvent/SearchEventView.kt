/*
 * *
 *   Created by Yoga Setiawan on 11/27/19 10:26 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/27/19 10:15 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *  
 */

package com.arioki.submission.ui.searchEvent

import com.arioki.submission.data.EventItem
import com.arioki.submission.data.LookupAllPlayerItem
import com.arioki.submission.data.LookupAllTeamItem

interface SearchEventView {
    fun getTextSearch(): String
    fun hiddenSimmer()
    fun finishSearchMatch(it: List<EventItem>)
    fun showShimmer()
    fun dataEmpty()
    fun getSearchType(): String
    fun searchError()
    fun finishSearchTeam(lookupAllTeamItem: List<LookupAllTeamItem>)
    fun finishSearchPlayer(lookupAllPlayerItem: List<LookupAllPlayerItem>)
}
