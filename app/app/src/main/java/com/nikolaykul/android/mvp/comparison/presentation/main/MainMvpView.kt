package com.nikolaykul.android.mvp.comparison.presentation.main

import com.nikolaykul.android.mvp.comparison.presentation.base.BaseMvpView

/**
 * Created by nikolay
 */

interface MainMvpView : BaseMvpView {
    fun showLoading()
    fun hideLoading()
    fun showLoginSuccess()
    fun showLoginError()
}