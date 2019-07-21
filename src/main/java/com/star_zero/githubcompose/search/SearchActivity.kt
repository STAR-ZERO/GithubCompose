package com.star_zero.githubcompose.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import com.star_zero.githubcompose.repos.ReposActivity
import timber.log.Timber

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                SearchForm(this::clickSearch)
            }
        }
    }

    private fun clickSearch(query: String) {
        Timber.d("query: $query")
        startActivity(ReposActivity.createIntent(this, query))
    }
}
