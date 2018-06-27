package ru.katakin.rxkotlinretrofit

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import ru.katakin.rxkotlinretrofit.di.DaggerAppComponent

class App : DaggerApplication() {

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}