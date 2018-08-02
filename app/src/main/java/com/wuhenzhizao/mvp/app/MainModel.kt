package com.wuhenzhizao.mvp.app

import com.wuhenzhizao.mvp.BaseModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainModel : BaseModel() {


    fun getList(): Disposable {
        return Observable.just(1, 2, 3)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ it ->
                    print("MainPresenter $it")
                }, { throwable ->
                    print(throwable)
                })
    }
}