package ru.katakin.rxkotlinretrofit.ui.main

class MainPresenter(
        val view: MainInterface.View
) : MainInterface.Presenter {

    companion object {
        val TAG = MainPresenter::class.java.simpleName
    }

    override fun subscribe() {}

    override fun unsubscribe() {}
}