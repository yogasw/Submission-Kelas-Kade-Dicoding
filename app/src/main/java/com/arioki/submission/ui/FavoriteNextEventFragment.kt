package com.arioki.submission.ui


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
import kotlinx.android.synthetic.main.fragment_favorite_next_event.*

class FavoriteNextEventFragment : Fragment(), FavoriteNextEventView {

    private lateinit var presenter: FavoriteNextEventPresenter
    private lateinit var layoutManager: LinearLayoutManager

    override fun getDataDone(result: List<EventItem>) {
        val adapter = EventAdapter(context, result) {
            val intent = Intent(context, DetailEventActivity::class.java)
            intent.putExtra("idEvent", it.id?.toInt())
            startActivity(intent)
        }
        layoutManager = LinearLayoutManager(context)
        rvFavoriteNextEvent.layoutManager = layoutManager
        rvFavoriteNextEvent.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite_next_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter = FavoriteNextEventPresenter()
        presenter.attachView(this)
        presenter.getData()
        super.onViewCreated(view, savedInstanceState)
    }
}
