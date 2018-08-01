package com.wuhenzhizao.mvp.app

import com.wuhenzhizao.mvp.BasePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface Contract {
    interface Presenter {
        fun getData()
    }
}

class MainPresenter(view: MainView) : BasePresenter<MainView>(view), Contract.Presenter {

    override fun getData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun test() {
        addDisposable(Observable.just(1, 2, 3)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ it ->
                    print(it)
                }, { throwable ->
                    print(throwable)
                }))
    }
}