package com.example.mvpexample.data.source.remote

import java.lang.Exception

interface OnFetchDataListener<T> {
    fun onLoading()
    fun onSuccess(data: T)
    fun onError(exception: Exception?)
}
