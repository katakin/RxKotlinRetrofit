package ru.katakin.rxkotlinretrofit.ui.splash

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.katakin.rxkotlinretrofit.ui.base.BaseView

@StateStrategyType(AddToEndSingleStrategy::class)
interface SplashView: BaseView {

    fun navigateToAuth()

    fun navigateToMain()
}