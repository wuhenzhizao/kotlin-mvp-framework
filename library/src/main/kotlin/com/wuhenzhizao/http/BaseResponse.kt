package com.wuhenzhizao.http

/**
 * Created by shiyucheng on 2018/8/3.
 */
data class BaseResponse<T>(var code:Int,var errorMsg:String,var data:T) {

    fun isOk() = code == 200

}