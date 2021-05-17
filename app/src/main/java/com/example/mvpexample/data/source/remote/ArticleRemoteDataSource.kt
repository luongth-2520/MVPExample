package com.example.mvpexample.data.source.remote

import com.example.mvpexample.data.model.Article
import com.example.mvpexample.data.source.ArticleDataSource
import com.example.mvpexample.data.source.remote.helper.FetchDataTask
import com.example.mvpexample.utils.Constants

class ArticleRemoteDataSource private constructor() : ArticleDataSource.Remote {

    override fun getListArticles(listener: OnFetchDataListener<MutableList<Article>>) {
        FetchDataTask(listener).execute(Constants.BASE_URL)
    }

    private object Holder {
        var INSTANCE = ArticleRemoteDataSource()
    }

    companion object {
        @JvmStatic
        fun getInstance(): ArticleRemoteDataSource {
            return Holder.INSTANCE
        }
    }

}
