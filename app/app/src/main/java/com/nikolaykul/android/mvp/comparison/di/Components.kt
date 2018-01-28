package com.nikolaykul.android.mvp.comparison.di

import com.nikolaykul.android.mvp.comparison.presentation.main.MainActivity
import dagger.Component
import dagger.Subcomponent
import javax.inject.Scope
import javax.inject.Singleton

/**
 * Created by nikolay
 */

@Singleton
@Component
interface ApplicationComponent {
    fun activityComponent(): ActivityComponent
}

@PerActivity
@Subcomponent
interface ActivityComponent {
    fun inject(activity: MainActivity)
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity

/**
 * Keep all components in one place
 */
object ComponentManager {
    private val appComponent: ApplicationComponent by lazy { DaggerApplicationComponent.create() }

    fun createActivityComponent(): ActivityComponent = appComponent.activityComponent()

}