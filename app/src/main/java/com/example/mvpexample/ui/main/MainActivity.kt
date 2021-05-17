package com.example.mvpexample.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mvpexample.R
import com.example.mvpexample.data.model.Article
import com.example.mvpexample.data.source.ArticleRepository
import com.example.mvpexample.ui.adapters.ArticleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private val articleAdapter by lazy {
        ArticleAdapter()
    }
    private val mainPresenter by lazy {
        MainPresenter(ArticleRepository.getInstance())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUp()
    }

    private fun setUp() {
        mainPresenter.setView(this)
        mainPresenter.onAttach()

        recyclerArticle.adapter = articleAdapter
        articleAdapter.setOnItemClickListener {
            Toast.makeText(this, it.title, Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.onDetach()
    }

    override fun showLoading() {
        progressArticle.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressArticle.visibility = View.GONE
    }

    override fun onSuccess(articles: MutableList<Article>) {
        articleAdapter.differ.submitList(articles)
    }

    override fun onError(e: Exception?) {
        Toast.makeText(this, "Error: ${e?.message}", Toast.LENGTH_LONG).show()
    }

}
