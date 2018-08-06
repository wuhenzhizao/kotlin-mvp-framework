package com.wuhenzhizao.image

import android.content.Context
import android.graphics.Bitmap
import android.text.TextUtils
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.wuhenzhizao.image.glide.CircularBitmapImageViewTarget

class GlideEngine : ImageEngine {

    override fun initConfig(context: Context) {

    }

    override fun load(context: Context, url: String, view: ImageView, options: Options) {
        val glideOptions = RequestOptions()
        //处理展位图
        glideOptions.placeholder(options.placeHolder)
        glideOptions.diskCacheStrategy(DiskCacheStrategy.ALL)
        if(options.imageInfo!=null){
            glideOptions.override(options.imageInfo!!.width, options.imageInfo!!.height)
        }
        //处理scaleType
        setScaleType(glideOptions, options.scaleType)
        val requestBuilder: RequestBuilder<Bitmap> = Glide.with(context).asBitmap().load(url).apply(glideOptions)
        //处理缩略图
        if (!TextUtils.isEmpty(options.thumbnail)) {
            val thumbnailRequest:RequestBuilder<Bitmap> = Glide
                    .with(context)
                    .asBitmap()
                    .load(options.thumbnail)
            requestBuilder.thumbnail(thumbnailRequest)
        }
        //处理圆角
        if (options.corner != 0f) {
            requestBuilder.into(CircularBitmapImageViewTarget(context, view, options.corner))
        } else {
            requestBuilder.into(view)
        }

    }

    override fun release() {

    }

    private fun setScaleType(requestOptions: RequestOptions, scaleType: ImageView.ScaleType) {
        when (scaleType) {
            ImageView.ScaleType.CENTER_CROP -> {
                requestOptions.centerCrop()
            }
            ImageView.ScaleType.CENTER_INSIDE -> {
                requestOptions.centerInside()
            }
            ImageView.ScaleType.FIT_CENTER -> {
                requestOptions.fitCenter()
            }
            else -> {
                requestOptions.centerCrop()
            }
        }
    }


}