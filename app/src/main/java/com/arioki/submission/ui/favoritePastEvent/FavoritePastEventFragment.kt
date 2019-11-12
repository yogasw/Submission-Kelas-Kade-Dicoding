package com.arioki.submission.ui.favoritePastEvent

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.arioki.submission.R
import com.arioki.submission.adapter.EventAdapter
import com.arioki.submission.data.EventItem
import com.arioki.submission.ui.detailEvent.DetailEventActivity
import kotlinx.android.synthetic.main.fragment_favorite_past_event.*

class FavoritePastEventFragment : Fragment(),
    FavoritePastEventView {
    override fun getDataDone(result: List<EventItem>) {
        rvFavoritePastEvent.layoutManager = LinearLayoutManager(context)
        rvFavoritePastEvent.adapter = EventAdapter(context, result) {
            val intent = Intent(context, DetailEventActivity::class.java)
            intent.putExtra("idEvent", it.id?.toInt())
            startActivity(intent)
        }
    }

    private lateinit var presenter: FavoritePastEventPresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite_past_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter = FavoritePastEventPresenter()
        presenter.attachView(this)
        presenter.getData()
        super.onViewCreated(view, savedInstanceState)
    }


}
