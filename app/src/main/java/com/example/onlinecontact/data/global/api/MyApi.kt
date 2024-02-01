package com.example.onlinecontact.data.global.api

import com.example.onlinecontact.data.global.response.ContactResponse
import retrofit2.Call
import retrofit2.http.GET

interface MyApi  {
    @GET("api/v1/contact")
    fun getAllContacts(): Call<List<ContactResponse>>
}