package ru.katakin.rxkotlinretrofit.ui.auth

import android.os.Bundle
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import ru.katakin.rxkotlinretrofit.R
import ru.katakin.rxkotlinretrofit.ui.base.BaseActivity
import ru.katakin.rxkotlinretrofit.utils.bindView
import javax.inject.Inject

class AuthActivity : BaseActivity(), AuthView {
    override val layoutResourceId: Int
        get() = R.layout.activity_auth

    @Inject @InjectPresenter lateinit var presenter: AuthPresenter
    @ProvidePresenter fun providePresenter() = presenter

    private val tokenView: TextView by bindView(R.id.auth_token)
    private val getTokenBtn: Button by bindView(R.id.auth_btn_get_token)
    private val closeBtn: Button by bindView(R.id.auth_btn_close)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getTokenBtn.setOnClickListener {
            presenter.getTokenBtnClicked()
        }
        closeBtn.setOnClickListener {
            finish()
        }
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