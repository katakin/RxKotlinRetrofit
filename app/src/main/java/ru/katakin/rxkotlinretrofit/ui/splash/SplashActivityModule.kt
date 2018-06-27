package ru.katakin.rxkotlinretrofit.ui.splash

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
        internal fun providePresenter(view: SplashInterface.View): SplashInterface.Presenter {
            return SplashPresenter(view)
        }
    }
}