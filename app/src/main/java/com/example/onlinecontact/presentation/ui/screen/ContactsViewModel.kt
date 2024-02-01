package com.example.onlinecontact.presentation.ui.screen

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlinecontact.data.global.MyClient
import com.example.onlinecontact.data.global.api.MyApi
import com.example.onlinecontact.data.global.response.ContactResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ContactsViewModel : ViewModel() {
    private val api = MyClient.retrofit.create(MyApi::class.java)
    private val list = ArrayList<ContactResponse>()

    val contactsLiveData = MutableLiveData<List<ContactResponse>>()
    val progressLiveData = MutableLiveData<Boolean>()

    fun loadContacts() {
        progressLiveData.value = true

        api.getAllContacts().enqueue(object : Callback<List<ContactResponse>> {
            override fun onResponse(
                call: Call<List<ContactResponse>>,
                response: Response<List<ContactResponse>>
            ) {
                progressLiveData.value = false

                if (response.isSuccessful) {
                    response.body()?.let {
                        contactsLiveData.value = it
                    }
                }
                else {
                    Log.d("TTT", "${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<List<ContactResponse>>, t: Throwable) {
                progressLiveData.value = false
                Log.d("TTT", "${t.message}")
            }
        })
    }
}