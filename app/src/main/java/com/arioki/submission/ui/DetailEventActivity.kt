package com.arioki.submission.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.arioki.submission.R
import com.arioki.submission.adapter.DetailEventAdapter
import com.arioki.submission.data.DetailEventItem
import com.arioki.submission.data.DetailEventListItem
import com.arioki.submission.ext.logger
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_event.*

class DetailEventActivity : AppCompatActivity(), DetailEventView {
    override fun finishLoadDataList(items: MutableList<DetailEventListItem>) {
        val layoutManager = LinearLayoutManager(applicationContext)
        val adapter = DetailEventAdapter(applicationContext, items)
        rvDetailEvent.layoutManager = layoutManager
        rvDetailEvent.isNestedScrollingEnabled = false
        rvDetailEvent.adapter = adapter
    }

    override fun finishLoadData(it: DetailEventItem) {
        it.logger(this)
        it.run {
            tvDetailHomeName.text = strHomeTeam
            tvHomeName.text = strHomeTeam

            tvDetailAwayName.text = strAwayTeam
            tvAwayName.text = strAwayTeam

            tvDetailHomeScore.text = intHomeScore
            tvDetailAwayScore.text = intAwayScore

            tvDetailNameEvent.text = strEvent
            tvDateTime.text = dateEvent

            Picasso.get()
                .load("https://www.thesportsdb.com/images/media/team/badge/a1af2i1557005128.png")
                .into(ivLogoHome, object : Callback {
                    override fun onSuccess() {
                        hiddenShimmer()
                    }

                    override fun onError(e: Exception?) {
                        "Error".logger(applicationContext)
                    }
                })

            Picasso.get()
                .load("https://www.thesportsdb.com/images/media/team/badge/a1af2i1557005128.png")
                .into(ivLogoAway, object : Callback {
                    override fun onSuccess() {
                        hiddenShimmer()
                    }

                    override fun onError(e: Exception?) {
                        "Error".logger(applicationContext)
                    }
                })

            Picasso.get()
                .load("https://www.thesportsdb.com/images/media/team/badge/a1af2i1557005128.png")
                .into(ivDetailHomeLogo, object : Callback {
                    override fun onSuccess() {
                        hiddenShimmer()
                    }

                    override fun onError(e: Exception?) {
                        "Error".logger(applicationContext)
                    }
                })
            Picasso.get()
                .load("https://www.thesportsdb.com/images/media/team/badge/a1af2i1557005128.png")
                .into(ivDetailAwayLogo, object : Callback {
                    override fun onSuccess() {
                        hiddenShimmer()
                    }

                    override fun onError(e: Exception?) {
                        "Error".logger(applicationContext)
                    }
                })

            val titles = resources.getStringArray(R.array.detailevent)
            presenter.getDataList(titles, this)
        }

    }

    override fun showShimmer() {
        shimmerLogoAwayDetail.startShimmerAnimation()
        shimmerLogoHomeyDetail.startShimmerAnimation()
        shimmerDateTime.startShimmerAnimation()
        shimmerDetailNameEvent.startShimmerAnimation()
        shimmeDetailEvent.startShimmerAnimation()
        shimmerConstraintLayout.startShimmerAnimation()
    }

    override fun hiddenShimmer() {
        shimmerLogoAwayDetail.visibility = View.GONE
        shimmerLogoHomeyDetail.visibility = View.GONE
        shimmerDateTime.visibility = View.GONE
        shimmerDetailNameEvent.visibility = View.GONE
        shimmeDetailEvent.visibility = View.GONE
        shimmerConstraintLayout.visibility = View.GONE
    }

    private lateinit var presenter: DetailEventPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_event)
        val id = intent.getIntExtra("idEvent", 0)
        presenter = DetailEventPresenter(id)
        presenter.attachView(this)
        presenter.getData()
    }
}
