/*
 * *
 *   Created by Yoga Setiawan on 12/11/19 10:46 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/16/19 7:13 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui

import android.graphics.Typeface
import android.os.Bundle
import android.util.Base64
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.arioki.submission.data.FootballItem
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {
    private var valName = ""
    private var valDescription = ""
    private var valBadge: Int = 0
    private lateinit var data: FootballItem

    companion object {
        const val bg = 1
        const val badge = 2
        const val description = 3
        const val name = 4
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        data = intent.getParcelableExtra("FootballItem")!!
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}
