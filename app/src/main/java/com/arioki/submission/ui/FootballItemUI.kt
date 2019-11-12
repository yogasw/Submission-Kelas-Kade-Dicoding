/*
 * *
 *   Created by Yoga Setiawan on 11/12/19 8:56 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/12/19 7:15 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui

import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import com.arioki.submission.R
import org.jetbrains.anko.*

class FootballItemUI : AnkoComponent<ViewGroup> {
    companion object {
        const val tvName = 1
        const val ivImage = 2
        const val vlItem = 3
    }

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            id = vlItem

            lparams(width = matchParent, height = wrapContent)
            padding = dip(16)
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            backgroundColor = Color.WHITE

            imageView{
                id= ivImage
                setImageResource(R.drawable.english_league_1)
            }.lparams(
                width = dip(50),
                height = dip(50)
            )
            textView {
                id = tvName
                text = R.string.sample.toString()
                padding = dip(5)
            }.lparams(
                width = wrapContent, height = wrapContent
            )
        }
    }
}
