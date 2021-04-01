package com.muratcanapps.mvp_login_screen.model

interface NetworkOperationsModelInterface {

    fun loginAuth(request : SignInWithEmailRequest) : NetworkResponse
}