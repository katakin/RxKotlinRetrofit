package ru.katakin.rxkotlinretrofit.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Binds
    internal abstract fun bindContext(application: Application): Context

    @Module
    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun providePreference(context: Context): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    }
}