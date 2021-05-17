package com.example.mvpexample.utils

import com.example.mvpexample.BuildConfig

object Constants {

    const val BASE_URL =
        "https://newsapi.org/v2/top-headlines?apiKey=${BuildConfig.API_KEY}&country=us&page=1"

}
