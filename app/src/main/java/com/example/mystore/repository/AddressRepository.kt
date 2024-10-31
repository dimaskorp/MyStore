package com.example.mystore.repository

import com.example.mystore.data_models.Suggestions
import com.example.mystore.model.AddressQueryRequest
import com.example.mystore.model.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AddressRepository {
    private var API_BASE_URL = "http://suggestions.dadata.ru"

    // Конфигурация Retrofit
    private var httpLoggingInterceptor: HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private var httpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private val apiService: ApiService = retrofit.create(ApiService::class.java)

    suspend fun searchAddresses(query: String): Suggestions? {
        val addressQuery = AddressQueryRequest(query) // Создаем объект запроса
        val response = apiService.searchAddress(addressQuery)
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
}
