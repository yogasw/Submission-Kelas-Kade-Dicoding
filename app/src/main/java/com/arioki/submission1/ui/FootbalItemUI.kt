package com.arioki.submission1.ui

import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import com.arioki.submission1.R
import org.jetbrains.anko.*

class FootbalItemUI : AnkoComponent<ViewGroup> {
    companion object {
        val tvName = 1
        val ivImage = 2
        val vlItem = 3
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
                text = "test"
                padding = dip(5)
            }.lparams(
                width = wrapContent, height = wrapContent
            )
        }
    }
}
