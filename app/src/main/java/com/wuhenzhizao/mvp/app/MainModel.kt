package com.wuhenzhizao.mvp.app

import com.wuhenzhizao.http.ServiceFactory
import com.wuhenzhizao.http.BaseResponse
import com.wuhenzhizao.http.HttpException
import com.wuhenzhizao.module.Callback
import com.wuhenzhizao.mvp.BaseModel
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

class MainModel : BaseModel() {


    fun getListAndRestore(callback: Callback<String>): Disposable {
//                return Observable.just(BaseResponse(200,"","返回数据"))
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({result ->
//                    result.data
//                })
//
//        return Observable.just(BaseResponse(200,"","返回数据"))
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(ResponseConsumer(callback))
        val observable = Observable.just(BaseResponse(200, "", "返回数据"))
        return subscribe(observable, object : Callback<String> {
            override fun onFailed(e: HttpException) {

            }

            override fun onSucceed(result: String) {
                //todo数据存储
                callback.onSucceed(result)
            }
        })
    }

        fun getList(callback: Callback<String>): Disposable {
            val observable = ServiceFactory.getService(ApiServcie::class.java).request("test11","test11")
            return subscribe(observable, callback)
    }
}