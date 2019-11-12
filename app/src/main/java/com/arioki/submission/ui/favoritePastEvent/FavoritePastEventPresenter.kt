package com.arioki.submission.ui.favoritePastEvent

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

class FavoritePastEventPresenter {
    var view: FavoritePastEventFragment? = null
    fun attachView(view: FavoritePastEventFragment) {
        this.view = view
    }

    @SuppressLint("SimpleDateFormat")
    fun getData() {
        try {
            App.instances.database.use {
                val data = select(Favorite.tbName)
                    .whereArgs("strDate < '${SimpleDateFormat("dd/M/yyyy").format(Date())}'")
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
