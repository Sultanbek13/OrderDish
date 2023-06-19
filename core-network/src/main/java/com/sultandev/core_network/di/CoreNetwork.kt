package com.sultandev.core_network.di


import com.sultandev.core_network.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CoreNetwork {

    val module = module {
        factory {
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor())
                .build()
        }

        single {
            Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(get())
                .build()
        }
    }
}