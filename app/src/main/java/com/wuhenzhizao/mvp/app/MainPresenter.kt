package com.wuhenzhizao.mvp.app

import com.wuhenzhizao.http.HttpException
import com.wuhenzhizao.module.Callback
import com.wuhenzhizao.rxbus.Pipe
import com.wuhenzhizao.rxbus.RxBus

class MainPresenter(view: MainContract.MainView) : MainContract.MainPresenter(view) {

    override fun getData() {
        val mainModel: MainModel = obtainModel(MainModel::class)

        addDisposable(mainModel.getList(object : Callback<String> {
            override fun onSucceed(result: String) {
                println(result)
            }

            override fun onFailed(e: HttpException) {
                println(e.toString())
            }

        }))

        RxBus.get().post("xxx", Pipe.Builder()
                .from(view.getActivity())
                .append("name", "wuhenzhizao")
                .build())
    }
}