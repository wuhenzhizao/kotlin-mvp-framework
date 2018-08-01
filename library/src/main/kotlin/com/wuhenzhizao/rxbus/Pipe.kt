package com.wuhenzhizao.rxbus

import android.content.Context
import java.lang.ref.SoftReference

class Pipe private constructor(context: Context?, private var args: Map<String, Any>) {
    private var contextRef: SoftReference<Context>? = null

    init {
        if (context != null) {
            this.contextRef = SoftReference(context)
        }
    }

    fun getContext(): Context? {
        if (contextRef != null) {
            return contextRef!!.get()
        }
        return null
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getParam(key: String): T {
        return args[key] as T
    }

    class Builder {
        private var context: Context? = null
        private var args: MutableMap<String, Any> = mutableMapOf()

        fun from(context: Context): Builder {
            this.context = context
            return this
        }

        fun append(key: String, value: Any): Builder {
            args[key] = value
            return this
        }

        fun build(): Pipe {
            return Pipe(context, args)
        }
    }
}