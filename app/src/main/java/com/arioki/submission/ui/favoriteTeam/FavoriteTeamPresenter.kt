/*
 * *
 *   Created by Yoga Setiawan on 12/9/19 9:21 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 12/9/19 9:21 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.favoriteTeam

import com.arioki.submission.data.LookupAllTeamItem
import com.arioki.submission.db.SportDBHelper
import com.arioki.submission.db.Team
import com.arioki.submission.repository.TheSportsDBRepository
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.parseList
import org.jetbrains.anko.db.select

class FavoriteTeamPresenter(
    val view: FavoriteTeamView,
    val repository: TheSportsDBRepository,
    val database: SportDBHelper
) {
    fun getData() {
        database.use {
            select(Team.tbName)
                .exec {
                    val data = parseList(object : MapRowParser<Map<String, Team>> {
                        override fun parseRow(columns: Map<String, Any?>): Map<String, Team> {
                            return columns as Map<String, Team>
                        }
                    })
                    val result = data.map { columns ->
                        LookupAllTeamItem(
                            null,
                            null,
                            columns[Team.id].toString(),
                            null,
                            null,
                            null,
                            null,
                            columns[Team.country].toString(),
                            null,
                            null,
                            columns[Team.description].toString(),
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            columns[Team.name].toString(),
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null
                        )
                    }
                    view.getDataDone(result)
                }
        }
    }
}
