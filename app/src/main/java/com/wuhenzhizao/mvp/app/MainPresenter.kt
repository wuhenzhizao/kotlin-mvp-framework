package com.wuhenzhizao.mvp.app

import com.wuhenzhizao.mvp.BasePresenter
import com.wuhenzhizao.rxbus.Pipe
import com.wuhenzhizao.rxbus.RxBus

class MainPresenter(view: MainContract.View) : BasePresenter<MainContract.View>(view), MainContract.Presenter {

    override fun getData() {
        val mainModel: MainModel = obtainModel(MainModel::class)

        addDisposable(mainModel.getList())

        RxBus.get().post("xxx", Pipe.Builder()
                .from(view.getActivity())
                .append("name", "wuhenzhizao")
                .build())
    }
}