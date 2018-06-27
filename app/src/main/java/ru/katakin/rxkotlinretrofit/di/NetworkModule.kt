package ru.katakin.rxkotlinretrofit.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.katakin.rxkotlinretrofit.BuildConfig
import ru.katakin.rxkotlinretrofit.network.ServiceApi
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideInterceptor(): HttpLoggingInterceptor =
            HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
            OkHttpClient.Builder()
                    .addNetworkInterceptor(loggingInterceptor)
                    .build()

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .baseUrl(BuildConfig.SERVER_URL)
                    .build()

    @Provides
    @Singleton
    fun provideServiceAPI(retrofit: Retrofit): ServiceApi = retrofit.create(ServiceApi::class.java)

}