package com.example.mvpexample.data.source

import com.example.mvpexample.data.model.Article
import com.example.mvpexample.data.source.remote.ArticleRemoteDataSource
import com.example.mvpexample.data.source.remote.OnFetchDataListener

class ArticleRepository private constructor(private val remote: ArticleDataSource.Remote) {

    fun getArticles(listener: OnFetchDataListener<MutableList<Article>>) {
        remote.getListArticles(listener)
    }

    private object Holder {
        val INSTANCE = ArticleRepository(ArticleRemoteDataSource.getInstance())
    }

    companion object {
        @JvmStatic
        fun getInstance(): ArticleRepository {
            return Holder.INSTANCE
        }
    }

}
