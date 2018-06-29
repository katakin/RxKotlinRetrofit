package ru.katakin.rxkotlinretrofit.ui.auth

import android.os.Bundle
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView
import ru.katakin.rxkotlinretrofit.R
import ru.katakin.rxkotlinretrofit.ui.base.BaseActivity
import ru.katakin.rxkotlinretrofit.utils.bindView
import javax.inject.Inject

class AuthActivity : BaseActivity(), AuthInterface.View {
    override val layoutResourceId: Int
        get() = R.layout.activity_auth

    @Inject lateinit var presenter: AuthInterface.Presenter

    private val tokenView: TextView by bindView(R.id.auth_token)
    private val getTokenBtn: Button by bindView(R.id.auth_btn_get_token)
    private val closeBtn: Button by bindView(R.id.auth_btn_close)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.subscribe()

        getTokenBtn.setOnClickListener({
            presenter.getTokenBtnClicked()
        })
        closeBtn.setOnClickListener({
            finish()
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
    }

    override fun showToken(accessToken: String?) {
        tokenView.text = accessToken
    }

    override fun addTokenWatcher(watcher: TextWatcher) {
        tokenView.addTextChangedListener(watcher)
    }

    override fun removeTokenWatcher(watcher: TextWatcher) {
        tokenView.removeTextChangedListener(watcher)
    }

    override fun setCloseVisibility(visibility: Int) {
        closeBtn.visibility = visibility
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}