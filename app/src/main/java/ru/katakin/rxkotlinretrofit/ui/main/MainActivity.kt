package ru.katakin.rxkotlinretrofit.ui.main

import android.os.Bundle
import ru.katakin.rxkotlinretrofit.R
import ru.katakin.rxkotlinretrofit.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), MainInterface.View {
    override val layoutResourceId: Int
        get() = R.layout.activity_main

    @Inject lateinit var presenter: MainInterface.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.subscribe()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
    }
}