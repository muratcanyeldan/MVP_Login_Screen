package com.muratcanapps.mvp_login_screen.network

import com.muratcanapps.mvp_login_screen.model.SignInWithEmailRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

const val postValue: String = "v1/accounts:signInWithPassword?key=" + Constants.API_KEY

interface LoginService {

    @POST(postValue)
    fun loginWithEmail(@Body request: SignInWithEmailRequest): Call<Any?>
}