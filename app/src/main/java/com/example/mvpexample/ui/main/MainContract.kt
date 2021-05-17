package com.example.mvpexample.ui.main

import com.example.mvpexample.data.model.Article
import com.example.mvpexample.ui.base.BasePresenter

interface MainContract {

    interface View {

        fun showLoading()

        fun hideLoading()

        fun onSuccess(articles: MutableList<Article>)

        fun onError(e: Exception?)

    }

    interface Presenter : BasePresenter<View> {
    }

}
