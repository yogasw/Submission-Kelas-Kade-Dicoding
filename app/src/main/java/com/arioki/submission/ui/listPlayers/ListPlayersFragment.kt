/*
 * *
 *   Created by Yoga Setiawan on 11/25/19 5:57 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/24/19 7:52 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.listPlayers


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.arioki.submission.R

/**
 * A simple [Fragment] subclass.
 */
class ListPlayersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_players, container, false)
    }


}
