package com.wuhenzhizao.mvp.app

import com.wuhenzhizao.mvp.BasePresenter
import com.wuhenzhizao.mvp.IBasePresenter
import com.wuhenzhizao.mvp.IBaseView

interface MainContract {

    interface MainView : IBaseView {
        fun setTitle(title: String)
    }


    abstract class MainPresenter(view:MainView) : BasePresenter<MainView>(view) {
        open fun getData(){

        }
    }
}