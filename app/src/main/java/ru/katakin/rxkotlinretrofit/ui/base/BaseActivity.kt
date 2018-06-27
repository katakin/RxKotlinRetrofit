package ru.katakin.rxkotlinretrofit.ui.base

import android.app.Activity
import android.os.Bundle
import android.util.Log
import dagger.android.support.DaggerAppCompatActivity
import ru.katakin.rxkotlinretrofit.App

abstract class BaseActivity : DaggerAppCompatActivity() {

    val Activity.app: App get() = application as App

    protected abstract val layoutResourceId: Int

    protected val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        setContentView(layoutResourceId)
    }
}