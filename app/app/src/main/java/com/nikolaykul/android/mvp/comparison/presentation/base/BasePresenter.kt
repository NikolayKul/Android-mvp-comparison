package com.nikolaykul.android.mvp.comparison.presentation.base

/**
 * Created by nikolay
 */

abstract class BasePresenter<TView : BaseMvpView> {
    protected var view: TView? = null

    open fun attachView(view: TView) {
        this.view = view
    }

    open fun detachView() {
        view = null
    }

}