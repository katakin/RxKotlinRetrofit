package ru.katakin.rxkotlinretrofit.ui.auth

import android.text.TextWatcher
import ru.katakin.rxkotlinretrofit.ui.base.BasePresenter

interface AuthInterface {

    interface View {
        fun showToken(accessToken: String?)

        fun addTokenWatcher(watcher: TextWatcher)

        fun removeTokenWatcher(watcher: TextWatcher)

        fun setCloseVisibility(visibility: Int)
    }

    interface Presenter : BasePresenter {
        fun getTokenBtnClicked()
    }
}