package com.example.mvpexample.data.source

import com.example.mvpexample.data.model.Article
import com.example.mvpexample.data.source.remote.ArticleRemoteDataSource
import com.example.mvpexample.data.source.remote.OnFetchDataListener

class ArticleRepository private constructor(private val remote: ArticleDataSource.Remote) {

    fun getArticles(listener: OnFetchDataListener<MutableList<Article>>) {
        remote.getListArticles(listener)
    }

    companion object {
        @Volatile
        private var instance: ArticleRepository? = null

        fun getInstance(): ArticleRepository = instance ?: synchronized(this) {
            instance ?: ArticleRepository(ArticleRemoteDataSource.getInstance()).also {
                instance = it
            }
        }
    }
}
