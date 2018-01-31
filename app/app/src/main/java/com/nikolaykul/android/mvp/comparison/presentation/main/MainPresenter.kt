package com.nikolaykul.android.mvp.comparison.presentation.main

import com.arellomobile.mvp.InjectViewState
import com.nikolaykul.android.mvp.comparison.domain.main.Credentials
import com.nikolaykul.android.mvp.comparison.domain.main.MainInteractor
import com.nikolaykul.android.mvp.comparison.presentation.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by nikolay
 */

@InjectViewState
class MainPresenter @Inject constructor(
        private val interactor: MainInteractor
) : BasePresenter<MainMvpView>() {

    fun login(username: String, password: String) {
        interactor.login(Credentials(username, password))
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showLoading() }
                .doOnTerminate { viewState.hideLoading() }
                .subscribe(
                        { viewState.showLoginSuccess() },
                        { viewState.showLoginError() })
    }

}