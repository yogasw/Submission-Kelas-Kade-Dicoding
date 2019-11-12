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
