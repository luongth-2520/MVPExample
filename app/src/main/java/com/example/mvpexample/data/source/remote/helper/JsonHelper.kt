package com.example.mvpexample.data.source.remote.helper

import com.example.mvpexample.data.model.Article
import com.example.mvpexample.data.model.ArticleEntry
import org.json.JSONObject

object JsonHelper {

    fun parseJson(jsonObject: JSONObject) = jsonObject.run {
        Article(
            getString(ArticleEntry.AUTHOR),
            getString(ArticleEntry.CONTENT),
            getString(ArticleEntry.DESCRIPTION),
            getString(ArticleEntry.PUBLIC_AT),
            getString(ArticleEntry.TITLE),
            getString(ArticleEntry.URL),
            getString(ArticleEntry.URL_TO_IMAGE)
        )
    }

    fun parseJsonArray(jsonObject: JSONObject): MutableList<Article> {
        val data: MutableList<Article> = mutableListOf()
        jsonObject.getJSONArray(ArticleEntry.OBJECT).let { array ->
            for (item in 0 until array.length()) {
                data.add(parseJson(array.getJSONObject(item)))
            }
        }
        return data
    }

}
