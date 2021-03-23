package com.muratcanapps.mvp_login_screen.presenter

import com.muratcanapps.mvp_login_screen.contract.ContractInterface

class LoginActivityPresenter(_view: ContractInterface.View) : ContractInterface.Presenter {

    private var view: ContractInterface.View = _view
    //private var model: Model = MainActivityModel()

    init {
        view.initView()
    }

    override fun incrementValue() {
        model.incrementCounter()
        view.updateViewData()
    }

    override fun getCounter() = model.getCounter().toString()

}