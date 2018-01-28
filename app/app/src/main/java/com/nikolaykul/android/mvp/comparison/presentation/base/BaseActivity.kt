package com.nikolaykul.android.mvp.comparison.presentation.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nikolaykul.android.mvp.comparison.di.ActivityComponent
import com.nikolaykul.android.mvp.comparison.di.ComponentManager

/**
 * Created by nikolay
 */

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ComponentManager.createActivityComponent()
                .let { injectSelf(it) }
    }

    protected abstract fun injectSelf(component: ActivityComponent)

}