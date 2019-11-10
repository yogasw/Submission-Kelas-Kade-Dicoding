package com.arioki.submission1.ui

import com.arioki.submission1.App

class DetailEventPresenter(var id: Int) {
    var view: DetailEventView? = null
    fun attachView(view: DetailEventView) {
        this.view = view
    }

    fun getData() {
        view?.showShimmer()
        App.instances.repository.detailEvent(id, {
            view?.hiddenShimmer()
            view?.finishLoadData(it)
        }, {
            view?.hiddenShimmer()
        })
    }


}