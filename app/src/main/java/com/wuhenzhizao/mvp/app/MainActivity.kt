package com.wuhenzhizao.mvp.app

import android.os.Bundle
import com.wuhenzhizao.base.BaseActivity

class MainActivity : BaseActivity(), MainContract.MainView {
    private lateinit var presenter: MainContract.MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)
        presenter.getData()
        addPresenter(presenter)
    }

    override fun setTitle(title: String) {

    }
}
