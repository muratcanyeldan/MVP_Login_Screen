package com.muratcanapps.mvp_login_screen.presenter

import com.muratcanapps.mvp_login_screen.model.NetworkResponse

interface LoginActivityPresenterInterface {
    fun login(email:String,password:String)
    fun transmitResponse(networkResponse : NetworkResponse)
}