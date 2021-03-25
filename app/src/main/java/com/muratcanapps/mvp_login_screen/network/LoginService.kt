package com.muratcanapps.mvp_login_screen.network

import com.muratcanapps.mvp_login_screen.model.SignInWithEmailRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

const val postValue: String = "v1/accounts:signInWithPassword?key=" + Constants.API_KEY

interface LoginService {

    //passive view yaklaşımı

    //interface yaklaşımı 6 tane en az view interface , activity interface
    //presenter , presenter interface
    //network , network interface

    //network katmanında olacak view model işlemleri

    @POST(postValue)
    fun loginWithEmail(@Body request: SignInWithEmailRequest): Call<Any?>
}