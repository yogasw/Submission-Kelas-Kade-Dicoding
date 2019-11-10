package com.arioki.submission.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.arioki.submission.R
import com.arioki.submission.adapter.FootbalAdapter
import com.arioki.submission.data.FootballItem
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainUi().setContentView(this)

    }

    class MainUi : AnkoComponent<MainActivity>, AnkoLogger {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            var items: MutableList<FootballItem> = mutableListOf()
            var name = resources.getStringArray(R.array.name)
            var id = resources.getStringArray(R.array.id)
            var description = resources.getStringArray(R.array.description)
            var badge = resources.obtainTypedArray(R.array.badge)
            items.clear()
            for (i in name.indices) {
                items.add(
                    FootballItem(
                        id[i],
                        name[i],
                        badge.getResourceId(i, 0),
                        description[i]
                    )
                )
            }
            badge.recycle()
            verticalLayout {

                var club_list = recyclerView {
                    lparams(
                        width = matchParent,
                        height = matchParent
                    )
                    layoutManager = LinearLayoutManager(ctx)
                    adapter = FootbalAdapter(ctx, items) {
                        //Penerapan dialog
                        toast(it.name.toString())

                        //Penerapan logging
                        info("Log Data")

                        //Penerapan Intent
                        var data: FootballItem = FootballItem(
                            it.id,
                            it.name,
                            it.badge,
                            it.description
                        )
                        startActivity<DetailLigaActivity>(
                            "FootballItem" to data
                        )

                    }
                }
            }
        }
    }
}
