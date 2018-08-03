package com.wuhenzhizao.module

import com.wuhenzhizao.http.HttpException

/**
 *
 * model中的接口回调
 */
interface Callback<in T> {
    fun onSucceed(result: T)

    fun onFailed(e : HttpException)
}