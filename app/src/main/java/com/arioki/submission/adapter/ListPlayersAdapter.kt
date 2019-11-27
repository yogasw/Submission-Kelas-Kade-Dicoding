/*
 * *
 *   Created by Yoga Setiawan on 11/27/19 9:31 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/27/19 9:31 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arioki.submission.R
import com.arioki.submission.data.LookupAllPlayerItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.info_team_items.view.*

class ListPlayersAdapter(
    var context: Context?,
    private var infoItems: List<LookupAllPlayerItem>,
    var listener: (LookupAllPlayerItem) -> Unit
) :
    RecyclerView.Adapter<ListPlayersAdapter.VH>() {

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(items: LookupAllPlayerItem, listener: (LookupAllPlayerItem) -> Unit) {
            itemView.tv_title.text = items.strPlayer
            itemView.tv_value.text = items.strNationality
            Picasso.get()
                .load(items.strCutout + "/preview")
                .into(itemView.image)
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPlayersAdapter.VH {
        return VH(LayoutInflater.from(context).inflate(R.layout.info_team_items, parent, false))
    }

    override fun getItemCount(): Int = infoItems.size

    override fun onBindViewHolder(holder: ListPlayersAdapter.VH, position: Int) {
        holder.bind(infoItems[position], listener)
    }

}