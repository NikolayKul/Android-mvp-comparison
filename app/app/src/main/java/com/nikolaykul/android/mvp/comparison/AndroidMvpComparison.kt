package com.nikolaykul.android.mvp.comparison

import android.app.Application
import com.nikolaykul.android.mvp.comparison.di.ApplicationComponent
import com.nikolaykul.android.mvp.comparison.di.ApplicationModule
import com.nikolaykul.android.mvp.comparison.di.DaggerApplicationComponent

/**
 * Created by nikolay
 */

class AndroidMvpComparison : Application() {
    private lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

}