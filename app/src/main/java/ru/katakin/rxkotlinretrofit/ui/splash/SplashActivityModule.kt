package ru.katakin.rxkotlinretrofit.ui.splash

import android.content.SharedPreferences
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class SplashActivityModule {

    @Binds
    abstract fun view(splashActivity: SplashActivity): SplashInterface.View

    @Module
    companion object {
        @JvmStatic
        @Provides
        internal fun providePresenter(view: SplashInterface.View, sp: SharedPreferences): SplashInterface.Presenter = SplashPresenter(view, sp)
    }
}