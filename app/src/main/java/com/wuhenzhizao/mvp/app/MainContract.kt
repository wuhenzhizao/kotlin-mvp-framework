package com.wuhenzhizao.mvp.app

import com.wuhenzhizao.mvp.IBasePresenter
import com.wuhenzhizao.mvp.IBaseView

interface MainContract {

    interface View : IBaseView {
        fun setTitle(title: String)
    }

    interface Presenter : IBasePresenter {
        fun getData()
    }
}