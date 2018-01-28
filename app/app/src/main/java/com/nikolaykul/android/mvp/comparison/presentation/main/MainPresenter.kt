package com.nikolaykul.android.mvp.comparison.presentation.main

import android.os.Handler
import android.os.Looper
import com.nikolaykul.android.mvp.comparison.presentation.base.BasePresenter

/**
 * Created by nikolay
 */

private const val LOADING_MILLIS = 500L

class MainPresenter : BasePresenter<MainMvpView>() {
    private val uiHandler: Handler by lazy { Handler(Looper.getMainLooper()) }

    fun login(username: String, password: String) {
        view?.apply {
            showLoading()
            uiHandler.postDelayed({
                showCredentials(username, password)
                hideLoading()
            }, LOADING_MILLIS)
        }
    }

}