package ru.katakin.rxkotlinretrofit.ui.main

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class MainActivityModule {

    @Binds
    abstract fun view(mainActivity: MainActivity): MainInterface.View

    @Module
    companion object {
        @JvmStatic
        @Provides
        internal fun providePresenter(view: MainInterface.View): MainInterface.Presenter = MainPresenter(view)
    }
}