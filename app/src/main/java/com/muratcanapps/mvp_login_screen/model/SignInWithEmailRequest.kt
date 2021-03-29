package com.muratcanapps.mvp_login_screen.model

import com.google.gson.annotations.SerializedName
import com.muratcanapps.mvp_login_screen.utils.isEmailValid
import com.muratcanapps.mvp_login_screen.utils.isPasswordValid

data class SignInWithEmailRequest(

        @SerializedName("email")
        override var email: String = "",

        @SerializedName("password")
        override var password: String = "",

        @SerializedName("returnSecureToken")
        override var returnSecureToken: Boolean = true

) : SignInWithEmailRequestInterface {
    override val isDataValid: Boolean
        get() = (isEmailValid(email) && isPasswordValid(password))

    //TODO(Buraya if email valid
    //    return 0
    //    else if password valid return 1
    //    vs şeklinde bir yapı kurulacak
    //    geri dönüş değeri int olacak ona göre okuma yapılacak)

}