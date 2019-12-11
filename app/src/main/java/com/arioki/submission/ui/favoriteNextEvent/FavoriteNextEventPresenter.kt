/*
 * *
 *   Created by Yoga Setiawan on 12/11/19 10:46 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/12/19 8:56 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.favoriteNextEvent

import android.annotation.SuppressLint
import android.database.sqlite.SQLiteConstraintException
import com.arioki.submission.App
import com.arioki.submission.data.DetailEventItem
import com.arioki.submission.data.EventItem
import com.arioki.submission.db.Favorite
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.parseList
import org.jetbrains.anko.db.select
import java.text.SimpleDateFormat
import java.util.*

class FavoriteNextEventPresenter {
    var view: FavoriteNextEventView? = null
    fun attachView(activity: FavoriteNextEventFragment) {
        view = activity
    }

    @SuppressLint("SimpleDateFormat")
    fun getData() {
        try {
            App.instances.database.use {
                val data = select(Favorite.tbName)
                    .whereArgs("strDate >= '${SimpleDateFormat("dd/M/yyyy").format(Date())}'")
                    .exec {
                        parseList(object : MapRowParser<Map<String, DetailEventItem?>> {
                            override fun parseRow(columns: Map<String, Any?>): Map<String, DetailEventItem?> {
                                return columns as Map<String, DetailEventItem?>
                            }

                        })
                    }
                val result = data.map { columns ->
                    EventItem(
                        columns["idEvent"].toString(),
                        columns["idHomeTeam"].toString(),
                        columns["idAwayTeam"].toString(),
                        columns["strEvent"].toString(),
                        columns["strDate"].toString(),
                        columns["strTime"].toString(),
                        columns["strHomeTeam"].toString(),
                        columns["strAwayTeam"].toString(),
                        columns["intHomeScore"].toString(),
                        columns["intAwayScore"].toString(),
                        columns["strLogoHome"].toString()
                        /* columns["strLogoAway"].toString()*/
                    )
                }

                view?.getDataDone(result)
            }
        } catch (e: SQLiteConstraintException) {
            e.printStackTrace()
        }
    }


}