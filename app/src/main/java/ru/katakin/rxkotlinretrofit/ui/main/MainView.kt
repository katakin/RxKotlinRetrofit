package ru.katakin.rxkotlinretrofit.ui.main

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.katakin.rxkotlinretrofit.ui.base.BaseView

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView: BaseView