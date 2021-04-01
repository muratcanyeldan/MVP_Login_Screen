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
    /*

    entity model burası. bunların interface e ihtiyacı var mı araştır. Yok gibi görünüyor ama net değil
    bu konuda biraz araştırma yapılması gerekiyor .Response kısmı da aynı şekilde interface gereksiz gibi

    network işlemlerinin yapıldığı model kısmına interface mutlaka gerekiyor.
     */
