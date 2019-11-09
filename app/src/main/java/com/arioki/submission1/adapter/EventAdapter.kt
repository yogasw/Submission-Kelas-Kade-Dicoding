package com.arioki.submission1.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arioki.submission1.R
import com.arioki.submission1.data.EventItem
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.league_items.view.*

class EventAdapter(
    private val context: Context?,
    private val items: List<EventItem>,
    private val listener: (EventItem) -> Unit
) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.league_items,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    class EventViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvHomeName: TextView = view.tvHomeName
        private val tvAwayName: TextView = view.tvAwayName
        private val tvHomesScore: TextView = view.tvHomeScore
        private val tvAwayScore: TextView = view.tvAwayScore
        private val ivHomeLogo: ImageView = view.ivHomeLogo
        private val ivAwayLogo: ImageView = view.ivAwayLogo

        fun bindItem(items: EventItem, listener: (EventItem) -> Unit) {
            tvHomeName.text = items.homeTeam
            tvAwayName.text = items.awayTeam
            tvHomesScore.text = items.homeTeamScore ?: "-"
            tvAwayScore.text = items.awayTeamScore ?: "-"
            Picasso.get()
                .load("https://www.thesportsdb.com/images/media/team/badge/a1af2i1557005128.png")
                .into(ivHomeLogo, object : Callback {
                    override fun onSuccess() {

                    }

                    override fun onError(e: Exception?) {
                        Log.d("LOGAPP", "error")
                    }
                })

            Picasso.get()
                .load("https://www.thesportsdb.com/images/media/team/badge/a1af2i1557005128.png")
                .into(ivAwayLogo, object : Callback {
                    override fun onSuccess() {

                    }

                    override fun onError(e: Exception?) {
                        Log.d("LOGAPP", "error")
                    }
                })
        }
    }
}
