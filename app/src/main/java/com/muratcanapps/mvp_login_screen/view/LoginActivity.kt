package com.muratcanapps.mvp_login_screen.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.muratcanapps.mvp_login_screen.R
import com.muratcanapps.mvp_login_screen.presenter.LoginActivityPresenter

class LoginActivity: AppCompatActivity(), LoginActivityInterface {

    private var presenter: LoginActivityPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginActivityPresenter(this)
    }


    override fun initView() {
        TODO("Not yet implemented")
    }

    override fun updateView() {
        TODO("Not yet implemented")
    }

}