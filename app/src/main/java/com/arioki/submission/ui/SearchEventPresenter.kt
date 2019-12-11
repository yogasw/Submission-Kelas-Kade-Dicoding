/*
 * *
 *   Created by Yoga Setiawan on 12/11/19 10:22 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/10/19 9:22 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui

import com.arioki.submission.App

class SearchEventPresenter {
    var view: SearchEventView? = null
    fun attachView(view: SearchEventActivity) {
        this.view = view
    }

    fun searchData(text: String) {
        view?.showShimmer()
        App.instances.repository.searchEvent(text, {
            view?.hiddenSimmer()
            view?.finishLoadData(it)
        }, {
            view?.dataEmpty()
        })

    }


}
