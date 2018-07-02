package ru.katakin.rxkotlinretrofit.ui.auth

import android.text.TextWatcher
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.katakin.rxkotlinretrofit.ui.base.BaseView

@StateStrategyType(AddToEndSingleStrategy::class)
interface AuthView: BaseView {

    fun showToken(accessToken: String?)

    fun addTokenWatcher(watcher: TextWatcher)

    fun removeTokenWatcher(watcher: TextWatcher)

    fun setCloseVisibility(visibility: Int)
}