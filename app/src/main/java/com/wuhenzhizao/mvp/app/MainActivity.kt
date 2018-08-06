package com.wuhenzhizao.mvp.app

import android.os.Bundle
import android.widget.ImageView
import com.wuhenzhizao.base.BaseActivity
import com.wuhenzhizao.image.ImageLoader

class MainActivity : BaseActivity(), MainContract.MainView {
    private lateinit var presenter: MainContract.MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)
        presenter.getData()
        addPresenter(presenter)
    }

    override fun onResume() {
        super.onResume()
        val iv: ImageView = findViewById(R.id.iv)
        ImageLoader.with(this).load("http://47.104.200.61/media/uploadImages/test.jpeg")
                .placeHolder(R.drawable.img_bg_1)
                .corner(20f)
                .into(iv)
    }

    override fun setTitle(title: String) {

    }
}
