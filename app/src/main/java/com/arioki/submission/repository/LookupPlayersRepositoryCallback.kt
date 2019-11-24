/*
 * *
 *   Created by Yoga Setiawan on 11/24/19 7:48 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/24/19 3:47 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.repository

import com.arioki.submission.data.LookupAllPlayerItem

interface LookupPlayersRepositoryCallback {
    fun onError(t: Throwable)
    fun onSuccess(lookupAllPlayerItem: List<LookupAllPlayerItem>)
}
