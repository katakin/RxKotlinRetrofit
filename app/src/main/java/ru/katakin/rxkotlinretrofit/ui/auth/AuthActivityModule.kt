package ru.katakin.rxkotlinretrofit.ui.auth

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.katakin.rxkotlinretrofit.network.ServiceApi

@Module
abstract class AuthActivityModule {

    @Binds
    abstract fun view(authActivity: AuthActivity): AuthInterface.View

    @Module
    companion object {
        @JvmStatic
        @Provides
        internal fun providePresenter(view: AuthInterface.View, api: ServiceApi): AuthInterface.Presenter = AuthPresenter(view, api)
    }
}