package com.wuhenzhizao.image

import android.content.Context
import android.widget.ImageView

interface ImageEngine {
    /**
     * app启动时候会调用，ImageEngine初始化工作
     */
    fun initConfig(context:Context)

    /**
     * 加载图片实现方法
     */
    fun load(context:Context,url: String, view: ImageView, options: Options)

    /**
     * 资源释放，app结束时候会调用
     */
    fun release()

//    fun with(context: Context)
//
//    fun load(url: String)
//
//    fun into()
//
//    fun placeHolder(resourceId: Int)
//
//    fun thumbnail(url:String)
//
//    fun corner(value:Float)
//
//    fun resize(width:Float,height:Float)

    // 占位图
    // 圆角
    // 切图服务
    // ScaleType
    // 缩略图
    //
}