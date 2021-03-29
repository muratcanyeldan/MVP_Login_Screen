package com.muratcanapps.mvp_login_screen.presenter

import android.util.Log
import com.google.gson.Gson
import com.muratcanapps.mvp_login_screen.model.SignInWithEmailRequest
import com.muratcanapps.mvp_login_screen.model.SignInWithEmailResponse
import com.muratcanapps.mvp_login_screen.network.LoginService
import com.muratcanapps.mvp_login_screen.network.ServiceGenerator
import com.muratcanapps.mvp_login_screen.view.LoginActivityInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivityPresenter(internal var view: LoginActivityInterface) :
    LoginActivityPresenterInterface {

    override fun login(email: String, password: String) {
        val request = SignInWithEmailRequest(email, password)
        if (request.isDataValid) {
            loginAuth(request)
        } else {
            transmitResponseToView(false, 2)
        }
    }

    override fun loginAuth(request: SignInWithEmailRequest) {

        var loggedInAccount: SignInWithEmailResponse? = null
        val loginService =
            ServiceGenerator.createService(LoginService::class.java, request)
        val call: Call<Any?> =
            loginService.loginWithEmail(request)

        call.enqueue(object : Callback<Any?> {
            override fun onResponse(
                call: Call<Any?>,
                response: Response<Any?>
            ) {

                if (response.isSuccessful) {
                    transmitResponseToView(true)
                    val successfulResponseGson = Gson().toJson(response.body())
                    val successfulResponse = Gson().fromJson(
                        successfulResponseGson,
                        SignInWithEmailResponse::class.java
                    )
                    loggedInAccount = successfulResponse
                    Log.d("responseBu", successfulResponse.email)
                } else {
                    val errorResponseFull = response.errorBody()?.string()
                    val errorResponseMessage = errorResponseFull?.substringAfter(""""message": """")
                        ?.substringBefore("""",""")
                    transmitResponseToView(false, message = errorResponseMessage)
                }
            }

            override fun onFailure(call: Call<Any?>, t: Throwable) {
                transmitResponseToView(false, 1)
            }
        })
    }

    private fun transmitResponseToView(
        status: Boolean,
        statusCode: Int = 0,
        message: String? = null
    ) {
        if (status) {
            view.onLoginResult(statusCode = statusCode, status = true)
        } else {
            view.onLoginResult(statusCode = statusCode, message = message)
        }
    }
}