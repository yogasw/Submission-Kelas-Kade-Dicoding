package com.arioki.submission1.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arioki.submission1.data.EventItem

class EventAdapter(
    val context: Context,
    val items: List<EventItem>,
    val listener: (EventItem) -> Unit
) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    class EventViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(items: EventItem, listener: (EventItem) -> Unit) {

        }
    }
}
