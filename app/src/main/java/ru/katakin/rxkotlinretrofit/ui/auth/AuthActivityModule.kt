package ru.katakin.rxkotlinretrofit.ui.auth

import dagger.Binds
import dagger.Module
import ru.katakin.rxkotlinretrofit.di.ActivityScope
import ru.katakin.rxkotlinretrofit.ui.base.BaseActivity

@Module
abstract class AuthActivityModule {

    @Binds
    @ActivityScope
    abstract fun view(authActivity: AuthActivity): BaseActivity
}