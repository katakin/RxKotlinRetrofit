package ru.katakin.rxkotlinretrofit.ui.splash

import android.os.Bundle
import ru.katakin.rxkotlinretrofit.R
import ru.katakin.rxkotlinretrofit.ui.base.BaseActivity

class SplashActivity : BaseActivity(), SplashInterface.View {
    override val layoutResourceId: Int
        get() = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}