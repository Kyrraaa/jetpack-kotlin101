package io.etna.mob2.kotlin101.api.repositories

import io.etna.mob2.kotlin101.models.Country
import retrofit2.Response
import retrofit2.http.GET

interface CountryRepository {

    // Route "/all" de l'API
    @GET("all")
    suspend fun getAllCountries(): Response<List<Country>>
}