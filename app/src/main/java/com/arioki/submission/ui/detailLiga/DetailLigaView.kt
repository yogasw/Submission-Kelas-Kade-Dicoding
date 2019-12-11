/*
 * *
 *   Created by Yoga Setiawan on 12/11/19 10:46 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/15/19 9:03 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.detailLiga

import com.arioki.submission.data.LeaguesItem

interface DetailLigaView {
    fun startShimmer()
    fun getDetailLigaFailed()
    fun getDetaiLigaDone(it: LeaguesItem)

}
