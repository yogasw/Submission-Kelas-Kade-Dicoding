/*
 * *
 *   Created by Yoga Setiawan on 12/8/19 11:26 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 12/8/19 11:25 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.db

data class Team(
    val id: String?,
    val name: String?,
    val country: String?,
    val description: String?
) {
    companion object {
        const val tbName: String = "favorite_team"
        const val id: String = "id"
        const val name: String = "name"
        const val country: String = "country"
        const val description: String = "description"
    }
}