package com.app.examenandroid.di

import com.app.examenandroid.data.remote.api.PaisApi
import com.app.examenandroid.data.repository.CountryRepositoryImpl
import com.app.examenandroid.domain.repository.CountryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// di/AppModule.kt
@Module // Indica que esta clase provee dependencias
@InstallIn(SingletonComponent::class) // Las dependencias viven durante toda la app
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit
            .Builder()
            .baseUrl("https://restcountries.com/") // URL base de la API
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providePaisApi(retrofit: Retrofit): PaisApi = retrofit.create(PaisApi::class.java)

    @Provides
    @Singleton
    fun provideCountryRepository(api: PaisApi): CountryRepository = CountryRepositoryImpl(api)
}
