package com.example.countries.data

import retrofit2.Response
import retrofit2.http.GET

//Within the api, take everything in the "all" section and return them in a list of Country objects
interface CountryService {
    @GET("all")
    suspend fun getCountryData(): Response<List<Country>>
}