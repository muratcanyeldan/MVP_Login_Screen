package com.muratcanapps.mvp_login_screen.model

import com.google.gson.annotations.SerializedName

data class SignInWithEmailRequest(

        @SerializedName("email")
        override var email: String = "",

        @SerializedName("password")
        override var password: String = "",

        @SerializedName("returnSecureToken")
        override var returnSecureToken: Boolean = true

) : SignInWithEmailRequestInterface
