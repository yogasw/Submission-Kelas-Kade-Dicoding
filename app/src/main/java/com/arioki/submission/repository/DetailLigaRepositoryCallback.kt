/*
 * *
 *   Created by Yoga Setiawan on 11/15/19 9:03 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/15/19 8:17 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.repository

import com.arioki.submission.data.LeaguesItem

interface DetailLigaRepositoryCallback {
    fun onError()
    fun onSuccess(leaguesItem: LeaguesItem)
}
