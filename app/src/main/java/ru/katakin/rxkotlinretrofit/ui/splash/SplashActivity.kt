package ru.katakin.rxkotlinretrofit.ui.splash

import android.content.Intent
import android.os.Bundle
import ru.katakin.rxkotlinretrofit.R
import ru.katakin.rxkotlinretrofit.ui.base.BaseActivity
import ru.katakin.rxkotlinretrofit.ui.main.MainActivity
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashInterface.View {
    override val layoutResourceId: Int
        get() = R.layout.activity_splash

    @Inject
    lateinit var presenter: SplashInterface.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.subscribe()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
    }

    override fun navigateToMain() {
        startActivity(Intent(this, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
        finish()
    }
}