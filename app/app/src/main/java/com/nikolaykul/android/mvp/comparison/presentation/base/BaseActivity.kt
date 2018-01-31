package com.nikolaykul.android.mvp.comparison.presentation.base

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.nikolaykul.android.mvp.comparison.di.ActivityComponent
import com.nikolaykul.android.mvp.comparison.di.ComponentManager

/**
 * Created by nikolay
 */

abstract class BaseActivity : MvpAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        ComponentManager.createActivityComponent()
                .let { injectSelf(it) }

        super.onCreate(savedInstanceState)
    }

    protected abstract fun injectSelf(component: ActivityComponent)

}