package ru.katakin.rxkotlinretrofit.network

import android.util.Base64
import okhttp3.Interceptor
import okhttp3.Response
import ru.katakin.rxkotlinretrofit.BuildConfig
import ru.katakin.rxkotlinretrofit.utils.token

class HeaderInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response {
        val original = chain!!.request()
        val builder = original.newBuilder()
        val url = original.url()

        return if ("oauth2" in url.pathSegments()) {
            builder.addHeader("Authorization", "Basic ${getBase64BearerToken()}")
            chain.proceed(builder.build())
        }  else {
            builder.addHeader("Authorization", "Bearer $token")
            chain.proceed(builder.build())
        }
    }

    private fun getBase64BearerToken(): String = Base64.encodeToString((BuildConfig.CONSUMER_KEY + ":" + BuildConfig.CONSUMER_SECRET).toByteArray(), Base64.NO_WRAP)
}