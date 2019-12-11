/*
 * *
 *   Created by Yoga Setiawan on 12/11/19 10:22 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 12/11/19 10:22 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arioki.submission.data.FootballItem
import com.arioki.submission.ui.FootbalItemUI
import com.squareup.picasso.Picasso
import org.jetbrains.anko.AnkoContext

class FootbalAdapter(
    val context: Context,
    private val items: List<FootballItem>,
    private val listener: (FootballItem) -> Unit
) :
    RecyclerView.Adapter<FootbalAdapter.FootbalViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FootbalViewHolder {
        return FootbalViewHolder(
            FootbalItemUI().createView(
                AnkoContext.create(
                    parent.context,
                    parent
                )
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: FootbalViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    class FootbalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvName: TextView = itemView.findViewById(FootbalItemUI.tvName)
        private val image: ImageView = itemView.findViewById(FootbalItemUI.ivImage)
        val vlItem: LinearLayout = itemView.findViewById(FootbalItemUI.vlItem)
        val clickListener: ((View) -> Unit)? = null
        fun bindItem(items: FootballItem, listener: (FootballItem) -> Unit) {
            tvName.text = items.name
            items.badge.let { Picasso.get().load(it).into(image) }
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }

}