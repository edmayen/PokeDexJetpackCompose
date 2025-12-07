package com.example.pokedexjetpackcompose.di

import com.example.pokedexjetpackcompose.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    fun provideRetrofit(json: Json): Retrofit =
        Retrofit
            .Builder()
            .baseUrl("")
            .addConverterFactory(json.asConverterFactory("application/json; charset=UTF8".toMediaType()))
            .build()

    @Provides
    fun provideJson(): Json =
        Json {
            ignoreUnknownKeys = true
            isLenient = true
        }
}