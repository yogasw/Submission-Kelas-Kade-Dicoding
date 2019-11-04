package com.arioki.submission1.ui

import android.graphics.Typeface
import android.os.Bundle
import android.util.Base64
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import com.arioki.submission1.data.FootballItem
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {
    var valName = ""
    var valDescription = ""
    var valBadge: Int = 0

    companion object {
        val bg = 1
        val badge = 2
        val description = 3
        val name = 4
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        var data: FootballItem = intent.getParcelableExtra("FootballItem")
        valName = data.name.toString()
        valDescription = data.description.toString()
        valBadge = data.badge

        val decrypt = Base64.decode(valDescription, Base64.DEFAULT)
        scrollView {
            relativeLayout {
                imageView {
                    id = bg
                    backgroundColor = resources.getColor(android.R.color.holo_blue_dark)
                }.lparams(width = matchParent, height = dip(200))

                imageView {
                    id = badge
                    setImageResource(valBadge)
                }.lparams(width = dip(150), height = dip(150)) {
                    centerHorizontally()
                    topMargin = dip(100)
                }

                textView {
                    id = description
                    padding = dip(16)
                    text = String(decrypt)
                }.lparams(width = matchParent) {
                    below(name)
                    topMargin = dip(24)
                }

                textView {
                    id = name
                    gravity = Gravity.CENTER
                    topPadding = dip(16)
                    text = valName
                    textSize = 24f
                    setTypeface(typeface, Typeface.BOLD)
                }.lparams(width = matchParent) {
                    below(badge)
                }
            }
        }
    }

}
