package com.arioki.submission1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.arioki.submission1.data.FootballItem
import com.arioki.submission1.R
import com.arioki.submission1.adapter.FootbalAdapter
import kotlinx.android.synthetic.main.activity_detail.view.*
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
                        startActivity<DetailActivity>(
                            "id" to it.id,
                            "name" to it.name,
                            "badge" to it.badge,
                            "description" to it.description
                        )

                    }
                }
            }
        }
    }
}
