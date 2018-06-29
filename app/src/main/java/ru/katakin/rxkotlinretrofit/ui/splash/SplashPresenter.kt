package ru.katakin.rxkotlinretrofit.ui.splash

import android.content.SharedPreferences
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import ru.katakin.rxkotlinretrofit.utils.token
import java.util.concurrent.TimeUnit

class SplashPresenter(
        val view: SplashInterface.View,
        val sp: SharedPreferences
) : SplashInterface.Presenter {

    companion object {
        val TAG = SplashPresenter::class.java.simpleName
    }

    private val compositeDisposable = CompositeDisposable()
    private val timerSubject = BehaviorSubject.timer(getSplashScreenDuration(), TimeUnit.MILLISECONDS)
    private val start = PublishSubject.create<Unit>()

    override fun subscribe() {
        compositeDisposable.add(
                Observable
                        .combineLatest<Long, Unit, Unit>(timerSubject, start, BiFunction { _, _ -> } )
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            when(token) {
                                null -> view.navigateToAuth()
                                else -> view.navigateToMain()
                            }
                        }
        )
    }

    override fun onStart() {
        start.onNext(Unit)
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