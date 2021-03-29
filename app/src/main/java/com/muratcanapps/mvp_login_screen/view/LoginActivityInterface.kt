package com.muratcanapps.mvp_login_screen.view

interface LoginActivityInterface {

    fun onLoginResult(message : String? = null , status : Boolean = false , statusCode : Int = 0)
}