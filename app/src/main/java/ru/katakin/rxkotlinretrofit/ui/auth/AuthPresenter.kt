package ru.katakin.rxkotlinretrofit.ui.auth

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.katakin.rxkotlinretrofit.network.ServiceApi

class AuthPresenter(
        val view: AuthInterface.View,
        private val api: ServiceApi
) : AuthInterface.Presenter {

    companion object {
        val TAG = AuthPresenter::class.java.simpleName
    }

    private val compositeDisposable = CompositeDisposable()
    private var watcher: TextWatcher? = null

    override fun subscribe() {
        compositeDisposable.add(
                Observable.create<String> { e ->
                    watcher = object : TextWatcher {
                        override fun afterTextChanged(s: Editable?) {
                            e.onNext(s.toString())
                        }

                        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                    }

                    view.addTokenWatcher(watcher as TextWatcher)

                    //init btn
                    e.onNext("")
                }
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe { s: String? ->
                            if (s.isNullOrEmpty()) {
                                view.setCloseVisibility(View.INVISIBLE)
                            } else {
                                view.setCloseVisibility(View.VISIBLE)
                            }
                        }
        )
    }

    override fun unsubscribe() {
        compositeDisposable.clear()
        watcher?.let {
            view.removeTokenWatcher(it)
        }
    }

    override fun getTokenBtnClicked() {
        api.getToken()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { accessToken ->
                    val token = accessToken.accessToken
                    ru.katakin.rxkotlinretrofit.utils.token = token
                    view.showToken(token)
                }
    }
}