package com.nikolaykul.android.mvp.comparison.presentation.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nikolaykul.android.mvp.comparison.di.ActivityComponent
import com.nikolaykul.android.mvp.comparison.di.ComponentManager

/**
 * Created by nikolay
 */

abstract class BaseActivity<out TPresenter : BasePresenter<*>> : AppCompatActivity() {
    protected val presenter: TPresenter by lazy { createPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ComponentManager.createActivityComponent()
                .let { injectSelf(it) }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    protected abstract fun createPresenter(): TPresenter

    protected abstract fun injectSelf(component: ActivityComponent)

}