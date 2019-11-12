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
