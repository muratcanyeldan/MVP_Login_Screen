package com.muratcanapps.mvp_login_screen.network

import com.muratcanapps.mvp_login_screen.model.SignInWithEmailRequest
import okhttp3.Credentials
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceGenerator {

    private val httpClient = OkHttpClient.Builder()
    private val builder = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    var retrofit: Retrofit = builder.build()

    fun <S> createService(
        serviceClass: Class<S>, request : SignInWithEmailRequest
    ): S {
        val authToken: String = Credentials.basic(request.email, request.password)
        return createService(serviceClass, authToken)
    }

    private fun <S> createService(
        serviceClass: Class<S>, authToken: String
    ): S {
        if (authToken.isNotEmpty()) {
            val interceptor = AuthenticationInterceptor(authToken)
            if (!httpClient.interceptors().contains(interceptor)) {
                httpClient.addInterceptor(interceptor)
                builder.client(httpClient.build())
                builder.addConverterFactory(GsonConverterFactory.create())
                retrofit = builder.build()
            }
        }
        return retrofit.create(serviceClass)
    }
}