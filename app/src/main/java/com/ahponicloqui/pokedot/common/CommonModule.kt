package com.ahponicloqui.pokedot.common

import com.ahponicloqui.pokedot.api.PokedotAPI
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.koin.dsl.module
import retrofit2.Retrofit

val commonModule = module {
    single {
        Json { ignoreUnknownKeys = true }
    }

    single {
        val networkJson : Json = get()
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
            .build().create(PokedotAPI::class.java)
    }
}