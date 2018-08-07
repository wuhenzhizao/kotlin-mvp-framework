package com.wuhenzhizao.image

import android.content.Context
import android.widget.ImageView

object ImageLoader {
    private lateinit var engine: ImageEngine

    /**
     *ImageLoader初始化
     */
    fun init(engineType: EngineType, context: Context) {
        initEngine(engineType)
        engine.initConfig(context.applicationContext)
    }

    /**
     * 释放资源
     */
    fun release() {
        engine.release()
    }

    /**
     * 获取builder对象
     */
    fun with(context: Context): Builder {
        return Builder(context)
    }

    private fun initEngine(engineType: EngineType) {
        engine = when (engineType) {
            EngineType.Glide -> {
                GlideEngine()
            }

            EngineType.Fresco -> {
                FrescoEngine()
            }

            EngineType.Picasso -> {
                PicassoEngine()
            }
        }
    }

    private fun display(context: Context, url: String, view: ImageView, options: Options) {
        engine.load(context, url, view, options)
    }

    enum class EngineType(val key: String, val engineType: Class<out ImageEngine>) {
        Glide("glide", GlideEngine::class.java),
        Fresco("fresco", FrescoEngine::class.java),
        Picasso("picasso", PicassoEngine::class.java),
    }

    open class Builder(private var context: Context) {
        private val options: Options = Options()
        private lateinit var url: String
        fun load(url: String): Builder {
            this.url = url
            return this
        }

        fun into(view: ImageView) {
            display(context, url, view, options)
        }

        fun placeHolder(resourceId: Int): Builder {
            options.placeHolder = resourceId
            return this
        }

        fun thumbnail(url: String): Builder {
            options.thumbnail = url
            return this
        }

        fun corner(value: Float): Builder {
            options.corner = value
            return this
        }

        fun resize(width: Int, height: Int): Builder {
            val imageInfo = Options.ImageInfo()
            imageInfo.height = height
            imageInfo.width = width
            options.imageInfo = imageInfo
            return this
        }
    }
}