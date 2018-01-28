package com.nikolaykul.android.mvp.comparison.presentation.base

/**
 * Created by nikolay
 */

abstract class BasePresenter<TView : BaseMvpView> {
    protected var view: TView? = null

    fun attachView(view: TView) {
        this.view = view
    }

    fun detachView() {
        view = null
    }

}