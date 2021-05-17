package com.example.mvpexample.data.model

data class Article(
    val author: String = "",
    val content: String = "",
    val description: String = "",
    val publishedAt: String = "",
    val title: String = "",
    val url: String = "",
    val urlToImage: String = ""
)

object ArticleEntry {
    const val OBJECT = "articles"
    const val AUTHOR = "author"
    const val CONTENT = "content"
    const val DESCRIPTION = "description"
    const val PUBLIC_AT = "publishedAt"
    const val TITLE = "title"
    const val URL = "url"
    const val URL_TO_IMAGE = "urlToImage"
}
