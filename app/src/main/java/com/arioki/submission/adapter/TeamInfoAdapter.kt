/*
 * *
 *   Created by Yoga Setiawan on 11/27/19 9:31 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/26/19 8:11 AM
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
import com.arioki.submission.data.TeamInfoItem
import kotlinx.android.synthetic.main.info_team_items.view.*

class TeamInfoAdapter(var context: Context?, var infoItems: List<TeamInfoItem>) :
    RecyclerView.Adapter<TeamInfoAdapter.VH>() {

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(items: TeamInfoItem) {
            itemView.image.visibility = View.GONE
            itemView.tv_title.text = items.title
            itemView.tv_value.text = items.value
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamInfoAdapter.VH {
        return VH(LayoutInflater.from(context).inflate(R.layout.info_team_items, parent, false))
    }

    override fun getItemCount(): Int = infoItems.size

    override fun onBindViewHolder(holder: TeamInfoAdapter.VH, position: Int) {
        holder.bind(infoItems[position])
    }
}