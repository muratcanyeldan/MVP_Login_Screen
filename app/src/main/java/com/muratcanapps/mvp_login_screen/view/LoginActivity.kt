package com.muratcanapps.mvp_login_screen.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.muratcanapps.mvp_login_screen.R
import com.muratcanapps.mvp_login_screen.databinding.ActivityLoginBinding
import com.muratcanapps.mvp_login_screen.extentions.toast
import com.muratcanapps.mvp_login_screen.presenter.LoginActivityPresenter
import com.muratcanapps.mvp_login_screen.presenter.LoginActivityPresenterInterface

class LoginActivity : AppCompatActivity(), LoginActivityInterface {

    internal lateinit var loginPresenter: LoginActivityPresenterInterface
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        loginPresenter = LoginActivityPresenter(this)
        binding.loginButton.setOnClickListener {
            val email = binding.emailInputField.text.toString().trim()
            val password = binding.passwordInputField.text.toString().trim()
            loginPresenter.login(email, password)
        }
    }

    override fun onLoginResult(message: String?, status: Boolean, statusCode: Int) {
        val statusArray: Array<String> = resources.getStringArray(R.array.status_codes)
        applicationContext.toast(message ?: statusArray[statusCode])
    }
}