package com.wuhenzhizao.image

import android.content.Context

interface ImageEngine {

    fun with(context: Context)

    fun load(url: String)

    fun into()

    fun placeHolder(resourceId: Int)

    fun thumbnail(url:String)

    fun corner(value:Float)

    fun resize(width:Float,height:Float)

    // 占位图
    // 圆角
    // 切图服务
    // ScaleType
    // 缩略图
    //
}