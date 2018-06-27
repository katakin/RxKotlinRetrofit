package ru.katakin.rxkotlinretrofit.network

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ServiceApi {

    @GET("/1.1/search/tweets.json")
    fun search(
            @Header("Authorization") bearerToken: String,
            @Query("q") query: String,
            @Query("count") count: String
    ) : Single<Response<ResponseBody>>
}