package com.example.mvpexample.ui.main

import com.example.mvpexample.data.model.Article
import com.example.mvpexample.data.source.ArticleRepository
import com.example.mvpexample.data.source.remote.OnFetchDataListener
import java.lang.Exception

class MainPresenter constructor(private val repository: ArticleRepository) :
    MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun setView(view: MainContract.View?) {
        this.view = view
    }

    override fun onAttach() {
        getArticles()
    }

    private fun getArticles() {
        repository.getArticles(object : OnFetchDataListener<MutableList<Article>> {
            override fun onLoading() {
                view?.showLoading()
            }

            override fun onSuccess(data: MutableList<Article>) {
                view?.hideLoading()
                view?.onSuccess(data)
            }

            override fun onError(exception: Exception?) {
                view?.hideLoading()
                view?.onError(exception)
            }

        })
    }

    override fun onDetach() {
        view = null
    }

}
