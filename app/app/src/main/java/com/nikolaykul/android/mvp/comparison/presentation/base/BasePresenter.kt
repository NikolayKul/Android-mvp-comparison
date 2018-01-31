package com.nikolaykul.android.mvp.comparison.presentation.base

import com.arellomobile.mvp.MvpPresenter

/**
 * Created by nikolay
 */

abstract class BasePresenter<TView : BaseMvpView> : MvpPresenter<TView>()