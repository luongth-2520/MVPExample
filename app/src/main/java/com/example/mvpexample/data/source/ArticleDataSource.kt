package com.example.mvpexample.data.source

import com.example.mvpexample.data.model.Article
import com.example.mvpexample.data.source.remote.OnFetchDataListener

interface ArticleDataSource {

    interface Local

    interface Remote {
        fun getListArticles(listener: OnFetchDataListener<MutableList<Article>>)
    }

}
