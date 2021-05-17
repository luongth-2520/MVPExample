package com.example.mvpexample.ui.base

interface BasePresenter<T> {
    fun setView(view: T?)
    fun onAttach()
    fun onDetach()
}
