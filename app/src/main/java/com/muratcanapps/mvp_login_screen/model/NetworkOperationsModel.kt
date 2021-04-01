package com.muratcanapps.mvp_login_screen.model

import com.google.gson.Gson
import com.muratcanapps.mvp_login_screen.network.LoginService
import com.muratcanapps.mvp_login_screen.network.ServiceGenerator
import com.muratcanapps.mvp_login_screen.presenter.LoginActivityPresenter
import com.muratcanapps.mvp_login_screen.presenter.LoginActivityPresenterInterface
import com.muratcanapps.mvp_login_screen.view.LoginActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkOperationsModel : NetworkOperationsModelInterface {
    private lateinit var loginPresenterInterface: LoginActivityPresenterInterface

    override fun loginAuth(request: SignInWithEmailRequest): NetworkResponse {
        var loggedInAccount: SignInWithEmailResponse? = null
        var errorResponseString: String? = null
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
                    val successfulResponseGson = Gson().toJson(response.body())
                    val successfulResponse = Gson().fromJson(
                        successfulResponseGson,
                        SignInWithEmailResponse::class.java
                    )
                    loggedInAccount = successfulResponse
                    transmitResponseToPresenter(NetworkResponse(loggedInAccount))

                } else {
                    val errorResponseFull = response.errorBody()?.string()
                    errorResponseString = errorResponseFull?.substringAfter(""""message": """")
                        ?.substringBefore("""",""")
                    transmitResponseToPresenter(NetworkResponse(errorResponseString = errorResponseString))
                }
            }

            override fun onFailure(call: Call<Any?>, t: Throwable) {
                transmitResponseToPresenter(NetworkResponse(errorResponseCode = 1))
            }
        })
        return NetworkResponse(loggedInAccount, errorResponseString)
    }

    private fun transmitResponseToPresenter(response: NetworkResponse) {
        loginPresenterInterface = LoginActivityPresenter(LoginActivity())
        loginPresenterInterface.transmitResponse(response)
    }
}