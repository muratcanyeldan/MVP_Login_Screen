package com.muratcanapps.mvp_login_screen.model

import com.google.gson.annotations.SerializedName

data class SignInWithEmailRequest(

    @SerializedName("email")
    var email: String,

    @SerializedName("password")
    var password: String,

    @SerializedName("returnSecureToken")
    var returnSecureToken: Boolean = true

)