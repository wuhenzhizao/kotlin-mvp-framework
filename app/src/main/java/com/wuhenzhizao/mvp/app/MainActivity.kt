package com.wuhenzhizao.mvp.app

import android.os.Bundle
import com.wuhenzhizao.base.BaseActivity

class MainActivity : BaseActivity(), MainView {
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)
        addPresenter(presenter)
    }
}
