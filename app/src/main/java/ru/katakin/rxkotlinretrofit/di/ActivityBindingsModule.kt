package ru.katakin.rxkotlinretrofit.di

import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector
import ru.katakin.rxkotlinretrofit.ui.auth.AuthActivity
import ru.katakin.rxkotlinretrofit.ui.auth.AuthActivityModule
import ru.katakin.rxkotlinretrofit.ui.main.MainActivity
import ru.katakin.rxkotlinretrofit.ui.main.MainActivityModule
import ru.katakin.rxkotlinretrofit.ui.splash.SplashActivity
import ru.katakin.rxkotlinretrofit.ui.splash.SplashActivityModule

@Module(includes = [AndroidInjectionModule::class])
abstract class ActivityBindingsModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    internal abstract fun splashActivityInjector(): SplashActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [AuthActivityModule::class])
    internal abstract fun authActivityInjector(): AuthActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun mainActivityInjector(): MainActivity
}