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

class LoginActivityPresenter(internal var view : LoginActivityInterface) : LoginActivityPresenterInterface {
    override fun login(email: String, password: String) {
        val request = SignInWithEmailRequest(email,password)

        var loggedInAccount: SignInWithEmailResponse? = null
        val loginService =
                ServiceGenerator.createService(LoginService::class.java, email, password)
        val call: Call<Any?> =
                loginService.loginWithEmail(SignInWithEmailRequest(email, password))

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
                    transmitResponseToView(false, errorResponseMessage)
                }
            }

            override fun onFailure(call: Call<Any?>, t: Throwable) {
                transmitResponseToView(false, "API endpoint can't be reached")
            }
        })


        val isLoginSuccess = request.isDataValid
        if(isLoginSuccess){
            //success
        }
        else{
            //fail
        }

    }


}