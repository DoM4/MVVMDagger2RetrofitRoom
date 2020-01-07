package com.domenicoaumenta.mvvm_dagger2_retrofit_room.di

import com.domenicoaumenta.mvvm_dagger2_retrofit_room.model.APIError
import com.domenicoaumenta.mvvm_dagger2_retrofit_room.network.UserApi
import com.domenicoaumenta.mvvm_dagger2_retrofit_room.utils.BASE_URL
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by domenicoaumenta on 2020-01-02.
 */
@Module
object NetworkModule {

    /** Provides Retrofit Object
     *
     * @return Retrofit object
     *
     */
    @Provides
    fun provideRetrofitInterface() : Retrofit{

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()


        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(client)
            .build()
    }

    /** Provides UserApi service implementation
     *
     * @param retrofit the Retrofit object used to instantiate the Service
     *
     * @return User service implementation
     *
     */
    @Provides
    fun provideUserApi(retrofit: Retrofit) : UserApi{
        return retrofit.create(UserApi::class.java)
    }
}