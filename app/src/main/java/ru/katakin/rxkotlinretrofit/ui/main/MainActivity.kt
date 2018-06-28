package ru.katakin.rxkotlinretrofit.ui.main

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.katakin.rxkotlinretrofit.R
import ru.katakin.rxkotlinretrofit.R.id.main_btn
import ru.katakin.rxkotlinretrofit.R.id.main_token
import ru.katakin.rxkotlinretrofit.ui.base.BaseActivity
import ru.katakin.rxkotlinretrofit.utils.token
import javax.inject.Inject

class MainActivity : BaseActivity(), MainInterface.View {

    override val layoutResourceId: Int
        get() = R.layout.activity_main

    @Inject lateinit var presenter: MainInterface.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.subscribe()

        main_btn.setOnClickListener({
            presenter.btnClicked()
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
    }

    override fun showToken(accessToken: String?) {
        token = accessToken
        main_token.setText(accessToken)
    }
}