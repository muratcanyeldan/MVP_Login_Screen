package com.muratcanapps.mvp_login_screen.presenter

import com.muratcanapps.mvp_login_screen.extentions.isNull
import com.muratcanapps.mvp_login_screen.model.NetworkOperationsModel
import com.muratcanapps.mvp_login_screen.model.NetworkOperationsModelInterface
import com.muratcanapps.mvp_login_screen.model.NetworkResponse
import com.muratcanapps.mvp_login_screen.model.SignInWithEmailRequest
import com.muratcanapps.mvp_login_screen.utils.isEmailValid
import com.muratcanapps.mvp_login_screen.utils.isPasswordValid
import com.muratcanapps.mvp_login_screen.view.LoginActivityInterface

class LoginActivityPresenter(internal var view: LoginActivityInterface) :
    LoginActivityPresenterInterface {
    private lateinit var networkModelInterface : NetworkOperationsModelInterface
    lateinit var response : NetworkResponse

    override fun login(email: String, password: String) {
        val request = SignInWithEmailRequest(email, password)
        if (isDataValid(request)) {
            networkModelInterface = NetworkOperationsModel()
            response = networkModelInterface.loginAuth(request)
        } else {
            transmitResponseToView(false, 2)
        }
    }

    override fun transmitResponse(networkResponse: NetworkResponse) {
        response = networkResponse
        handleNetworkResponse(response)
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

    private fun isDataValid(request : SignInWithEmailRequest) : Boolean{
        return isEmailValid(request.email) && isPasswordValid(request.password)
    }



    private fun handleNetworkResponse(response : NetworkResponse){
        if(!response.signInWithEmailResponse.isNull()){
            transmitResponseToView(true)
        }
        else{
            transmitResponseToView(false,response.errorResponseCode?:0,response.errorResponseString)
        }
    }
}