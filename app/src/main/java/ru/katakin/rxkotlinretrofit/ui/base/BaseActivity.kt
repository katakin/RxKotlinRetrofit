package ru.katakin.rxkotlinretrofit.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import com.arellomobile.mvp.MvpAppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity : MvpAppCompatActivity(), HasFragmentInjector, HasSupportFragmentInjector {

    @Inject lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>
    @Inject lateinit var frameworkFragmentInjector: DispatchingAndroidInjector<android.app.Fragment>

    protected abstract val layoutResourceId: Int

    protected val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        setContentView(layoutResourceId)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return supportFragmentInjector
    }

    override fun fragmentInjector(): AndroidInjector<android.app.Fragment> {
        return frameworkFragmentInjector
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}