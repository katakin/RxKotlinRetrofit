package ru.katakin.rxkotlinretrofit.ui.main

import com.arellomobile.mvp.InjectViewState
import ru.katakin.rxkotlinretrofit.di.ActivityScope
import ru.katakin.rxkotlinretrofit.ui.base.BasePresenter
import javax.inject.Inject


@ActivityScope
@InjectViewState
class MainPresenter @Inject constructor(
) : BasePresenter<MainView>() {

    companion object {
        val TAG = MainPresenter::class.java.simpleName
    }
}