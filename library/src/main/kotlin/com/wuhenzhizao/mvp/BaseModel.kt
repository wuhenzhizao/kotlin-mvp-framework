package com.wuhenzhizao.mvp

import com.wuhenzhizao.http.BaseResponse
import com.wuhenzhizao.http.HttpException
import com.wuhenzhizao.http.ResponseConsumer
import com.wuhenzhizao.module.Callback
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

abstract class BaseModel : IBaseModel {

    override fun destroy() {}

    fun <T>subscribe(observable: Observable<BaseResponse<T>>,callback:Callback<T>): Disposable {
        return observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(ResponseConsumer(callback), Consumer<Throwable> {
                    t: Throwable? ->
                    callback.onFailed(HttpException(635, t?.message!!,t))
                })
    }
}