package com.muratcanapps.mvp_login_screen.presenter

import com.muratcanapps.mvp_login_screen.view.LoginActivityInterface

class LoginActivityPresenter(_view: LoginActivityInterface) : LoginActivityPresenterInterface {

    private var view: LoginActivityInterface = _view
    //private var model: Model = MainActivityModel()


    override fun init() {
        view.initView()
    }

}