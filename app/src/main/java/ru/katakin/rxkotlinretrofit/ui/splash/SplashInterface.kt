package ru.katakin.rxkotlinretrofit.ui.splash

import ru.katakin.rxkotlinretrofit.ui.base.BasePresenter

interface SplashInterface {

    interface View {
        fun navigateToAuth()

        fun navigateToMain()
    }

    interface Presenter : BasePresenter {
        fun onStart()
    }
}