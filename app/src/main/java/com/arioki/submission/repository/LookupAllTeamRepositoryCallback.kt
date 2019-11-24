/*
 * *
 *   Created by Yoga Setiawan on 11/24/19 1:54 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/24/19 11:10 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.repository

import com.arioki.submission.data.LookupAllTeamItem

interface LookupAllTeamRepositoryCallback {
    fun onError(t: Throwable)
    fun onSuccess(lookupAllTeamItem: List<LookupAllTeamItem>)
}
