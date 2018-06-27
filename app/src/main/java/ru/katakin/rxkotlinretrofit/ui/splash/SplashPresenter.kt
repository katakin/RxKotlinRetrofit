package ru.katakin.rxkotlinretrofit.ui.splash

class SplashPresenter(
        val view: SplashInterface.View
) : SplashInterface.Presenter {

    companion object {
        val TAG = SplashPresenter::class.java.simpleName
    }

    override fun subscribe() {
    }

    override fun unsubscribe() {
    }
}