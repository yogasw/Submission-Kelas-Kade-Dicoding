/*
 * *
 *   Created by Yoga Setiawan on 11/24/19 1:54 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/23/19 11:25 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(
    fm: FragmentManager,
    private var pages: List<Fragment>,
    private var title: List<String>
) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return title[position]
    }
}