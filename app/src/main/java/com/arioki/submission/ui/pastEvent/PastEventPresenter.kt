/*
 * *
 *   Created by Yoga Setiawan on 11/12/19 8:56 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/12/19 7:33 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.pastEvent

import com.arioki.submission.App

class PastEventPresenter(var id: Int) {
    private var view: PastEventFragment? = null

    fun attachView(view: PastEventFragment) {
        this.view = view
    }

    fun getData() {
        App.instances.repository.pastEvent(id, {
            view?.hiddenSimmer()
            view?.getDataDone(it)
        }, {
            view?.hiddenSimmer()
        })
    }

}
