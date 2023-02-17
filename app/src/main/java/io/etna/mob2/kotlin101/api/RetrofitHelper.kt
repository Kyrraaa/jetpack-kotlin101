package io.etna.mob2.kotlin101.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val baseUrl: String = "https://restcountries.com/v3.1/"

    fun getInstance(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
                // Lire le JSON
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}