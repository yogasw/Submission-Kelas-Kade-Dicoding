/*
 * *
 *   Created by Yoga Setiawan on 11/12/19 8:56 AM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/12/19 7:33 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.nextEvent


import com.arioki.submission.App

class NextEventPresenter(private var id: Int) {
    var view: NextEventFragment? = null
    fun attachView(view: NextEventFragment) {
        this.view = view
    }

    fun getData() {
        App.instances.repository.nextEvent(id, {
            view?.hiddenSimmer()
            view?.getDataDone(it)
        }, {
            view?.hiddenSimmer()
        })
    }

}
