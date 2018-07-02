package ru.katakin.rxkotlinretrofit.ui.base

import com.arellomobile.mvp.MvpPresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter<V : BaseView> : MvpPresenter<V>() {

    private val compositeDisposable = CompositeDisposable()

    protected fun Disposable.connect() {
        compositeDisposable.add(this)
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}