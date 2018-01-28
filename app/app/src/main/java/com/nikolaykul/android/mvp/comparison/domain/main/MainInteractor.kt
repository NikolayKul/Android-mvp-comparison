package com.nikolaykul.android.mvp.comparison.domain.main

import dagger.Reusable
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by nikolay
 */

private const val LOADING_MILLIS = 1000L

@Reusable
class MainInteractor @Inject constructor() {

    fun login(credentials: Credentials): Completable = performLogin(credentials)
            .delay(LOADING_MILLIS, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.computation())

    private fun performLogin(credentials: Credentials): Completable = Completable.defer {
        if (credentials.isValid()) {
            Completable.complete()
        } else {
            Completable.error(WrongCredentialsError())
        }
    }

}