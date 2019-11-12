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
