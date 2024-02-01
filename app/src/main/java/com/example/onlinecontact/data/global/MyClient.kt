package com.example.onlinecontact.data.global

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyClient {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://8a11-94-158-61-221.ngrok-free.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}