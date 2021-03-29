package com.muratcanapps.mvp_login_screen.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.muratcanapps.mvp_login_screen.R
import com.muratcanapps.mvp_login_screen.presenter.LoginActivityPresenter
import com.muratcanapps.mvp_login_screen.presenter.LoginActivityPresenterInterface

class LoginActivity: AppCompatActivity(), LoginActivityInterface {

    internal lateinit var loginPresenter : LoginActivityPresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginPresenter = LoginActivityPresenter(this)


    }

    override fun onLoginResult() {
        TODO("Not yet implemented")
    }

}