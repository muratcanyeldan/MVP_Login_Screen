package com.muratcanapps.mvp_login_screen.model


interface SignInWithEmailRequestInterface {

    var email: String

    var password: String

    var returnSecureToken: Boolean

}