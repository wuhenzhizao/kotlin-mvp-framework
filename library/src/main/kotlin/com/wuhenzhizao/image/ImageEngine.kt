package com.wuhenzhizao.image

import android.content.Context

interface ImageEngine {

    fun with(context: Context)

    fun load(url: String)

    fun into()

    fun placeHolder(resourceId: Int)
}