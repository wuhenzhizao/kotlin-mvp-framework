package com.wuhenzhizao.image.glide

import android.content.Context
import android.graphics.Bitmap
import android.support.v4.graphics.drawable.RoundedBitmapDrawable
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.widget.ImageView
import com.bumptech.glide.request.target.BitmapImageViewTarget

/**
 * 实现圆角图片
 * Created by shiyucheng on 2018/8/6.
 */
class CircularBitmapImageViewTarget(val context: Context, private val imageView: ImageView, private val cornerRadius: Float) : BitmapImageViewTarget(imageView) {
    override fun setResource(resource: Bitmap?) {
        val bitmapDrawable: RoundedBitmapDrawable = RoundedBitmapDrawableFactory.create(context.resources, resource)
        /**
         *   设置图片的shape为圆形.
         *
         *   若是需要制定圆角的度数，则调用setCornerRadius（）。
         */
        bitmapDrawable.isCircular = true
        bitmapDrawable.cornerRadius = cornerRadius
        imageView.setImageDrawable(bitmapDrawable)
    }

}