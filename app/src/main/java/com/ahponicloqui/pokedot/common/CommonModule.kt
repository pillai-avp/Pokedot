package com.ahponicloqui.pokedot.common

import com.ahponicloqui.pokedot.api.PokedotAPI
import com.ahponicloqui.pokedot.repository.PokedotDataSource
import com.ahponicloqui.pokedot.repository.PokedotRepository
import com.ahponicloqui.pokedot.service.PokedotServiceHandler
import com.ahponicloqui.pokedot.service.PokedotServices
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import timber.log.Timber
import java.util.concurrent.TimeUnit

val commonModule = module {
    single {
        Json { ignoreUnknownKeys = true }
    }

    single {
        val logging = HttpLoggingInterceptor { message -> Timber.tag("OkHttp").d(message) }.apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)

        }
        val okHttpConfig: OkHttpClient.Builder = OkHttpClient.Builder().apply {
            retryOnConnectionFailure(false)
            connectTimeout(30, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(30, TimeUnit.SECONDS)
            addInterceptor(logging)
        }
        okHttpConfig.build()
    }

    single {
        val networkJson : Json = get()
        Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .client(get())
            .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
            .build().create(PokedotAPI::class.java)
    }

    single<PokedotRepository> {
        PokedotDataSource(api = get())
    }

    single<PokedotServices> {
        PokedotServiceHandler(repository = get())
    }
}