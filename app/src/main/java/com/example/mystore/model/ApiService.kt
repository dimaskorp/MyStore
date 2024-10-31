package com.example.mystore.model

import com.example.mystore.data_models.Suggestions
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @Headers("Accept: application/json", "Authorization: Token 444cd01c3ee7af4a9f3706457c8c5d864f8fa0e7") // Укажите ваш токен в заголовках
    @POST("/suggestions/api/4_1/rs/suggest/address")
    suspend fun searchAddress(
        @Body addressQuery: AddressQueryRequest // Передаем объект AddressQueryRequest
    ): Response<Suggestions>
}

// Модель для запроса
data class AddressQueryRequest(val query: String)

