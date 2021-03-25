package com.muratcanapps.mvp_login_screen.model

import com.google.gson.annotations.SerializedName

data class SignInWithEmailResponse(

        @SerializedName("kind")
        override var kind: String = "",

        @SerializedName("localId")
        override var localId: String = "",

        @SerializedName("email")
        override var email: String = "",

        @SerializedName("displayName")
        override var displayName: String = "",

        @SerializedName("idToken")
        override var idToken: String = "",

        @SerializedName("registered")
        override var registered: Boolean = false,

        @SerializedName("refreshToken")
        override var refreshToken: String = "",

        @SerializedName("expiresIn")
        override var expiresIn: String = ""

) : SignInWithEmailResponseInterface