package com.arioki.submission.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arioki.submission.App
import com.arioki.submission.R
import com.arioki.submission.data.EventItem
import com.facebook.shimmer.ShimmerFrameLayout
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
        private val tvHomeName: TextView = view.tvDetailHomeName
        private val tvAwayName: TextView = view.tvDetailAwayName
        private val tvHomesScore: TextView = view.tvDetailHomeScore
        private val tvAwayScore: TextView = view.tvDetailAwayScore
        private val ivHomeLogo: ImageView = view.ivDetailHomeLogo
        private val ivAwayLogo: ImageView = view.ivDetailAwayLogo

        private val shimmerHome: ShimmerFrameLayout = view.shimmerHome
        private val shimmerAway: ShimmerFrameLayout = view.shimmerAway

        fun bindItem(items: EventItem, listener: (EventItem) -> Unit) {
            tvHomeName.text = items.homeTeam
            tvAwayName.text = items.awayTeam

            if (items.homeTeamScore == "null" || items.homeTeamScore == null || items.homeTeamScore == "") {
                tvHomesScore.text = "-"
            } else {
                tvHomesScore.text = items.homeTeamScore
            }

            if (items.awayTeamScore == "null" || items.awayTeamScore == null || items.awayTeamScore == "") {
                tvAwayScore.text = "-"
            } else {
                tvAwayScore.text = items.homeTeamScore
            }

            val idHomeTeam = items.idHomeTeam?.toInt()
            val idAwayTeam = items.idAwayTeam?.toInt()

            ivHomeLogo.setImageResource(android.R.color.transparent)
            ivAwayLogo.setImageResource(android.R.color.transparent)
            shimmerHome.startShimmerAnimation()
            shimmerAway.startShimmerAnimation()
            shimmerHome.visibility = View.VISIBLE
            shimmerAway.visibility = View.VISIBLE

            if (idHomeTeam != null) {
                App.instances.repository.lookupTeam(idHomeTeam,
                    {
                        it.run {

                            Picasso.get()
                                .load(strTeamBadge)
                                .into(ivHomeLogo, object : Callback {
                                    override fun onSuccess() {
                                        shimmerHome.visibility = View.GONE
                                    }

                                    override fun onError(e: Exception?) {
                                        shimmerHome.visibility = View.GONE
                                    }
                                })
                        }
                    }, {
                        it.printStackTrace()
                    })
            }

            if (idAwayTeam != null) {
                App.instances.repository.lookupTeam(idAwayTeam, {
                    it.run {
                        Picasso.get()
                            .load(strTeamBadge)
                            .into(ivAwayLogo, object : Callback {
                                override fun onSuccess() {
                                    shimmerAway.visibility = View.GONE
                                }

                                override fun onError(e: Exception?) {
                                    shimmerAway.visibility = View.GONE
                                    Log.d("LOGAPP", "error")
                                }
                            })

                    }
                }, {

                })
            }
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}
