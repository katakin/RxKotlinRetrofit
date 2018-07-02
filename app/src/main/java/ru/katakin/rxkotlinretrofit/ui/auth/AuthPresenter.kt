package ru.katakin.rxkotlinretrofit.ui.auth

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.arellomobile.mvp.InjectViewState
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.katakin.rxkotlinretrofit.di.ActivityScope
import ru.katakin.rxkotlinretrofit.network.ServiceApi
import ru.katakin.rxkotlinretrofit.ui.base.BasePresenter
import javax.inject.Inject

@ActivityScope
@InjectViewState
class AuthPresenter @Inject constructor(
        private val api: ServiceApi
) : BasePresenter<AuthView>() {

    companion object {
        val TAG = AuthPresenter::class.java.simpleName
    }

    private var watcher: TextWatcher? = null

    fun subscribe() {
        Observable.create<String> { e ->
            watcher = object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    e.onNext(s.toString())
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            }

            viewState.addTokenWatcher(watcher as TextWatcher)

            //init btn
            e.onNext("")
        }
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { s: String? ->
                    if (s.isNullOrEmpty()) {
                        viewState.setCloseVisibility(View.INVISIBLE)
                    } else {
                        viewState.setCloseVisibility(View.VISIBLE)
                    }
                }.connect()
    }

    fun unsubscribe() {
        watcher?.let {
            viewState.removeTokenWatcher(it)
        }
    }

    fun getTokenBtnClicked() {
        api.getToken()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { accessToken ->
                    val token = accessToken.accessToken
                    ru.katakin.rxkotlinretrofit.utils.token = token
                    viewState.showToken(token)
                }.connect()
    }
}