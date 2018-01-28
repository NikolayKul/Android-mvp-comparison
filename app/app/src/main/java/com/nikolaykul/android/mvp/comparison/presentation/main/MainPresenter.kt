package com.nikolaykul.android.mvp.comparison.presentation.main

import com.nikolaykul.android.mvp.comparison.presentation.base.BasePresenter

/**
 * Created by nikolay
 */

class MainPresenter : BasePresenter<MainMvpView>() {

    fun login(username: String, password: String) {
        view?.apply {
            showLoading()
            showCredentials(username, password)
            hideLoading()
        }
    }

}