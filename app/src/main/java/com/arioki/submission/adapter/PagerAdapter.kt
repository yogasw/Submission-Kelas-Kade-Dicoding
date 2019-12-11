/*
 * *
 *   Created by Yoga Setiawan on 12/11/19 10:22 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/10/19 11:31 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.arioki.submission.ui.NextMatchFragment
import com.arioki.submission.ui.PastEventFragment

class PagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val pages = listOf(
        NextMatchFragment(),
        PastEventFragment()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Next Match"
            else -> "Past Match"
        }
    }
}