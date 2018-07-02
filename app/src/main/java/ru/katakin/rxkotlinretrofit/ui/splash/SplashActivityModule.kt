package ru.katakin.rxkotlinretrofit.ui.splash

import dagger.Binds
import dagger.Module
import ru.katakin.rxkotlinretrofit.di.ActivityScope
import ru.katakin.rxkotlinretrofit.ui.base.BaseActivity

@Module
abstract class SplashActivityModule {

    @Binds
    @ActivityScope
    abstract fun view(splashActivity: SplashActivity): BaseActivity
}