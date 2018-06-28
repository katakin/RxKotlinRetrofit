package ru.katakin.rxkotlinretrofit.data

import com.google.gson.annotations.SerializedName

data class AccessToken(
        @SerializedName("token_type")
        val tokenType: String,

        @SerializedName("access_token")
        val accessToken: String
)