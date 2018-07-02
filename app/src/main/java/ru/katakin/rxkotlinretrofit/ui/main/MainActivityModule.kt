package ru.katakin.rxkotlinretrofit.ui.main

import dagger.Binds
import dagger.Module
import ru.katakin.rxkotlinretrofit.di.ActivityScope
import ru.katakin.rxkotlinretrofit.ui.base.BaseActivity

@Module
abstract class MainActivityModule {

    @Binds
    @ActivityScope
    abstract fun view(mainActivity: MainActivity): BaseActivity
}