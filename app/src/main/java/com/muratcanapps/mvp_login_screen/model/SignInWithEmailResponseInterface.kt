package com.muratcanapps.mvp_login_screen.model

interface SignInWithEmailResponseInterface {

    var kind: String

    var localId: String

    var email: String

    var displayName: String

    var idToken: String

    var registered: Boolean

    var refreshToken: String

    var expiresIn: String
}