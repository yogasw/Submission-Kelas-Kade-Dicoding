/*
 * *
 *   Created by Yoga Setiawan on 12/8/19 11:26 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 12/8/19 11:25 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.detailTeam

import com.arioki.submission.data.LookupAllTeamItem
import com.arioki.submission.db.SportDBHelper
import com.arioki.submission.db.Team
import com.arioki.submission.repository.TheSportsDBRepository
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

class DetailTeamPresenter(
    val view: DetailTeamView,
    val repository: TheSportsDBRepository,
    val database: SportDBHelper,
    val data: LookupAllTeamItem?
) {
    fun addFavoriteItem() {
        try {
            data?.run {
                database.use {
                    insert(
                        Team.tbName,
                        Team.id to idTeam,
                        Team.name to strTeam,
                        Team.country to strCountry,
                        Team.description to strDescriptionEN
                    )
                }
                view.showRemoveFavoriteButton()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun removeFavoriteItem() {
        try {
            data?.run {
                database.use {
                    delete(Team.tbName, "${Team.id} = $idTeam")
                }
            }
            view.showAddFavoriteButton()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun checkData() {
        try {
            data?.run {
                database.use {
                    select(Team.tbName)
                        .whereArgs("${Team.id} == $idTeam")
                        .exec {
                            view.checkDataFinish(count)
                        }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
