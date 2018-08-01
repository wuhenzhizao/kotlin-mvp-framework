package com.wuhenzhizao.mvp.app

import com.wuhenzhizao.mvp.BasePresenter
import com.wuhenzhizao.mvp.IBasePresenter
import com.wuhenzhizao.rxbus.Pipe
import com.wuhenzhizao.rxbus.RxBus
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface Contract {
    interface Presenter : IBasePresenter {
        fun getData()
    }
}

class MainPresenter(view: MainView) : BasePresenter<MainView>(view), Contract.Presenter {

    override fun getData() {
        val mainModel: MainModel = obtainModel(MainModel::class)

        addDisposable(Observable.just(1, 2, 3)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ it ->
                    print("MainPresenter $it")
                }, { throwable ->
                    print(throwable)
                }))

        RxBus.get().post("xxx", Pipe.Builder().from(view.getActivity()).append("name", "wuhenzhizao").build())
    }
}