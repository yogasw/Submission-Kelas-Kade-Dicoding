package com.arioki.submission1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import android.util.Base64
import com.arioki.submission1.R


class DetailActivity : AppCompatActivity() {
    var valName = ""
    var valDescription = ""
    var valBadge : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        valName = intent.getStringExtra("name")
        valDescription = intent.getStringExtra("description")
        valBadge = intent.getIntExtra("badge",0)
        name.text = valName
        val decrypt = Base64.decode(valDescription, Base64.DEFAULT)
        description.text = String(decrypt)
        badge?.let { Picasso.get().load(valBadge).into(badge) }

    }
}
