package com.imaec.pagingwithcoroutine.service

import com.imaec.pagingwithcoroutine.model.Passenger
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface TestService {

    companion object {
        @Volatile
        private var instance: Retrofit? = null

        fun getInstance(): TestService {
            if (instance == null) {
                synchronized(this::class.java) {
                    val client = OkHttpClient.Builder()
                        .addInterceptor(
                            HttpLoggingInterceptor().apply {
                                level = HttpLoggingInterceptor.Level.BODY
                            }
                        )
                        .connectTimeout(1, TimeUnit.MINUTES)
                        .readTimeout(1, TimeUnit.MINUTES)
                        .build()
                    instance = Retrofit.Builder()
                        .baseUrl("https://api.instantwebtools.net")
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(CoroutineCallAdapterFactory())
                        .client(client)
                        .build()
                }
            }
            return instance!!.create(TestService::class.java)
        }
    }

    @GET("/v1/passenger")
    suspend fun getData(
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Passenger
}