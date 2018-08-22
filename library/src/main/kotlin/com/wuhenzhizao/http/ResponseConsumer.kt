package com.wuhenzhizao.http

import com.wuhenzhizao.module.Callback
import io.reactivex.functions.Consumer

/**
 * Created by shiyucheng on 2018/8/3.
 */
class ResponseConsumer<T>(private val callback: Callback<T>) : Consumer<BaseResponse<T>> {
    override fun accept(t: BaseResponse<T>) {
//        if(t.isOk()){
//            callback.onSucceed(t.data)
//        }else{
//            callback.onFailed(HttpException(t.code,t.errorMsg, Throwable(t.errorMsg)))
//        }
        callback.onSucceed(t.data)
    }

}