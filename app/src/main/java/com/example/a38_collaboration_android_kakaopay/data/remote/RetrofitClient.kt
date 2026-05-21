package com.example.a38_collaboration_android_kakaopay.data.remote

import com.example.a38_collaboration_android_kakaopay.BuildConfig
import com.example.a38_collaboration_android_kakaopay.data.remote.api.AssetsApi
import com.example.a38_collaboration_android_kakaopay.data.remote.api.ExpenseApi
import com.example.a38_collaboration_android_kakaopay.data.remote.api.SpendingAnalysisApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

object RetrofitClient {
    private const val BASE_URL = BuildConfig.BASE_URL
    private val json = Json { ignoreUnknownKeys = true }

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val instance: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(json.asConverterFactory("application/json; charset=UTF-8".toMediaType()))
        .build()

    fun <T> create(service: Class<T>): T = instance.create(service)

    val assetsApi: AssetsApi by lazy {
        create(AssetsApi::class.java)
    }

    val expenseApi: ExpenseApi by lazy {
        create(ExpenseApi::class.java)
    }

    val spendingAnalysisApi: SpendingAnalysisApi by lazy {
        create(SpendingAnalysisApi::class.java)
    }
}
