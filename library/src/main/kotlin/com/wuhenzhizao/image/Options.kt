package com.wuhenzhizao.image

import android.widget.ImageView

/**
 * Created by shiyucheng on 2018/8/6.
 */
class Options {
     var scaleType: ImageView.ScaleType = ImageView.ScaleType.CENTER_CROP
     var placeHolder:Int = 0
     var thumbnail:String = ""
     var corner:Float = 0f
     var imageInfo:ImageInfo? = null


    open class ImageInfo{
         var height:Int = 0
         var width:Int = 0
    }

}