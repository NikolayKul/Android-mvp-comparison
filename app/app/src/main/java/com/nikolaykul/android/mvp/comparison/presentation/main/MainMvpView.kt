package com.nikolaykul.android.mvp.comparison.presentation.main

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.nikolaykul.android.mvp.comparison.presentation.base.BaseMvpView

/**
 * Created by nikolay
 */

interface MainMvpView : BaseMvpView {

    fun showLoading()

    fun hideLoading()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showLoginSuccess()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showLoginError()

}