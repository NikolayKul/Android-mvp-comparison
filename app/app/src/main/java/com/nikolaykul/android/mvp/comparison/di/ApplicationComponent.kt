package com.nikolaykul.android.mvp.comparison.di

import android.app.Application
import android.content.Context
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Singleton

/**
 * Created by nikolay
 */

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
}

@Module
class ApplicationModule(private val app: Application) {

    @Provides
    @Singleton
    @AppContext
    fun provideApplicationContext(): Context = app.applicationContext


}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class AppContext