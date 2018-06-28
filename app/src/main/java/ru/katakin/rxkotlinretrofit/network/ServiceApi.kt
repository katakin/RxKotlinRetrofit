package ru.katakin.rxkotlinretrofit.network

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

import ru.katakin.rxkotlinretrofit.data.AccessToken

interface ServiceApi {

    @GET("/1.1/search/tweets.json")
    fun search(
            @Query("q") query: String,
            @Query("count") count: String
    ) : Single<Response<ResponseBody>>

    @FormUrlEncoded
    @POST("/oauth2/token")
    @Headers(
            "User-Agent:My Twitter App v1.0.23",
            "Content-Type:application/x-www-form-urlencoded;charset=UTF-8"
    )
    fun getToken(
            @Field("grant_type") grant_type:String = "client_credentials"
    ): Single<AccessToken>
}