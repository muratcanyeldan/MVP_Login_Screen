package com.muratcanapps.mvp_login_screen.model

data class NetworkResponse(
    var signInWithEmailResponse: SignInWithEmailResponse?=null,
    var errorResponseString : String ? = null,
    var errorResponseCode : Int ? = null
)
