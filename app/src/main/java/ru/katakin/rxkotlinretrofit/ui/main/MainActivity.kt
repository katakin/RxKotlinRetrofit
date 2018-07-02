package ru.katakin.rxkotlinretrofit.ui.main

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import ru.katakin.rxkotlinretrofit.R
import ru.katakin.rxkotlinretrofit.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {
    override val layoutResourceId: Int
        get() = R.layout.activity_main

    @Inject @InjectPresenter lateinit var presenter: MainPresenter
    @ProvidePresenter fun providePresenter() = presenter
}