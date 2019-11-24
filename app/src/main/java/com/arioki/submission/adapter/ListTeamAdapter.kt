/*
 * *
 *   Created by Yoga Setiawan on 11/24/19 1:54 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/24/19 1:52 PM
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
import com.arioki.submission.data.LookupAllTeamItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_team_items.view.*

class ListTeamAdapter(
    private val context: Context?,
    private val lookupAllTeamItem: List<LookupAllTeamItem>,
    private val listener: (LookupAllTeamItem) -> Unit
) : RecyclerView.Adapter<ListTeamAdapter.VH>() {

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            items: LookupAllTeamItem,
            listener: (LookupAllTeamItem) -> Unit,
            position: Int
        ) {
            itemView.tv_no.text = (position + 1).toString()
            itemView.tv_country.text = items.strCountry
            itemView.tv_description.text = items.strDescriptionEN
            itemView.tv_name_team.text = items.strTeam
            Picasso.get()
                .load(items.strTeamBadge)
                .into(itemView.iv_badge)
            itemView.setOnClickListener {
                listener(items)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            LayoutInflater.from(context).inflate(R.layout.list_team_items, parent, false)
        )
    }

    override fun getItemCount(): Int = lookupAllTeamItem.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(lookupAllTeamItem[position], listener, position)
    }
}