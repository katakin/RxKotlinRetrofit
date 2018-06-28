package ru.katakin.rxkotlinretrofit.ui.main

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.katakin.rxkotlinretrofit.network.ServiceApi

class MainPresenter(
        val view: MainInterface.View,
        val api: ServiceApi
) : MainInterface.Presenter {

    companion object {
        val TAG = MainPresenter::class.java.simpleName
    }

    override fun subscribe() {
    }

    override fun unsubscribe() {
    }

    override fun btnClicked() {
        api.getToken()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { token ->
            view.showToken(token.accessToken)
        }
    }
}