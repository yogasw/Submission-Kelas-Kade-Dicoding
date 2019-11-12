/*
 * *
 *   Created by Yoga Setiawan on 11/12/19 8:56 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/12/19 7:21 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.searchEvent

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
