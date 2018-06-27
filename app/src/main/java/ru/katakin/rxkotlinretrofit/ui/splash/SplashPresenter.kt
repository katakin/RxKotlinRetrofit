package ru.katakin.rxkotlinretrofit.ui.splash

import android.content.SharedPreferences
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class SplashPresenter(
        val view: SplashInterface.View,
        val sp: SharedPreferences
) : SplashInterface.Presenter {

    companion object {
        val TAG = SplashPresenter::class.java.simpleName
    }

    val compositeDisposable = CompositeDisposable()

    override fun subscribe() {
        compositeDisposable.add(
                Single.timer(getSplashScreenDuration(), TimeUnit.MILLISECONDS)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe { _ -> view.navigateToMain() }
        )
    }

    override fun unsubscribe() {
        compositeDisposable.clear()
    }

    private fun getSplashScreenDuration(): Long {
        val prefKeyFirstLaunch = "pref_first_launch"

        return when (sp.getBoolean(prefKeyFirstLaunch, true)) {
            true -> {
                // If this is the first launch, make it slow (> 3 seconds) and set flag to false
                sp.edit().putBoolean(prefKeyFirstLaunch, false).apply()
                5000
            }
            false -> {
                // If the user has launched the app, make the splash screen fast (<= 1 seconds)
                1000
            }
        }
    }
}