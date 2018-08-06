package com.wuhenzhizao.mvp.app

import com.wuhenzhizao.http.BaseResponse
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by shiyucheng on 2018/8/6.
 */
interface ApiServcie {
    @POST("user/register")
    @FormUrlEncoded
    fun request(@Field("userName") userName:String,@Field("password") password:String):Observable<BaseResponse<String>>
}