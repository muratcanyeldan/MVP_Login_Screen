package com.muratcanapps.mvp_login_screen.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.muratcanapps.mvp_login_screen.R
import com.muratcanapps.mvp_login_screen.contract.ContractInterface
import com.muratcanapps.mvp_login_screen.presenter.LoginActivityPresenter

class LoginActivity: AppCompatActivity(), ContractInterface.View {

    private var presenter: LoginActivityPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginActivityPresenter(this)
    }

    /*
    override fun initView() {
        counterTextView.text = presenter?.getCounter()
        clickButton.setOnClickListener { presenter?.incrementValue() }
    }

    override fun updateViewData() {
        counterTextView.text = presenter?.getCounter()
    }
    */

}