package com.arioki.submission1.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arioki.submission1.ui.FootbalItemUI
import com.arioki.submission1.data.FootballItem
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class FootbalAdapter(
    val context: Context,
    val items: List<FootballItem>,
    val listener: (FootballItem) -> Unit
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
        holder.bindItem(items[position],listener)
    }

    class FootbalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvName: TextView = itemView.findViewById(FootbalItemUI.tvName)
        var image: ImageView = itemView.findViewById(FootbalItemUI.ivImage)
        var vlItem: LinearLayout = itemView.findViewById(FootbalItemUI.vlItem)
        var clickListener: ((View) -> Unit)? = null
        fun bindItem(items: FootballItem, listener: (FootballItem) -> Unit) {
            tvName.text = items.name
            items.badge?.let { Picasso.get().load(it).into(image) }
            itemView.setOnClickListener{
                listener(items)
            }
        }
    }

}