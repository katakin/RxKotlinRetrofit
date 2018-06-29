package ru.katakin.rxkotlinretrofit.utils

import android.preference.PreferenceManager
import ru.katakin.rxkotlinretrofit.App

var token: String?
    get() = PreferenceManager.getDefaultSharedPreferences(App.instance).getString("token", null)
    set(value) = PreferenceManager.getDefaultSharedPreferences(App.instance).edit().putString("token", value).apply()