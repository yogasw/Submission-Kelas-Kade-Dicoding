package com.arioki.submission.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arioki.submission.R
import com.arioki.submission.data.DetailEventListItem
import kotlinx.android.synthetic.main.detail_event_items.view.*

class DetailEventAdapter(var context: Context?, var items: List<DetailEventListItem>) :

    RecyclerView.Adapter<DetailEventAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.detail_event_items, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        private val home: TextView = view.tvHome
        private val title: TextView = view.tvTitle
        private val away: TextView = view.tvAway
        fun bindItem(detailEventListItem: DetailEventListItem) {
            home.text = detailEventListItem.home
            title.text = detailEventListItem.title
            away.text = detailEventListItem.away
        }
    }

}
