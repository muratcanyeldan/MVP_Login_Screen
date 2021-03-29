package com.muratcanapps.mvp_login_screen.presenter

import com.muratcanapps.mvp_login_screen.model.SignInWithEmailRequest

interface LoginActivityPresenterInterface {
    fun login(email:String,password:String)
    fun loginAuth(request : SignInWithEmailRequest)
}