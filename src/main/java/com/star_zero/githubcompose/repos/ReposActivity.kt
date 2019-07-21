package com.star_zero.githubcompose.repos

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.onActive
import androidx.compose.onCommit
import androidx.compose.onDispose
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.lifecycle.ViewModelProviders
import androidx.ui.material.MaterialTheme
import com.star_zero.githubcompose.data.Repo
import androidx.lifecycle.Observer
import androidx.ui.core.setContent
import java.lang.IllegalArgumentException
import timber.log.Timber

class ReposActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(ReposViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                val repos = +state<List<Repo>?> { null }

                +onActive {
                    // onActiveでobserveしないと、stateが変更された時に何度もobserveしてしまう
                    viewModel.repos.observe(this@ReposActivity, object : Observer<List<Repo>> {
                        // lambda式を使うとビルド通らない
                        override fun onChanged(t: List<Repo>?) {
                            repos.value = t
                        }
                    })
                }

                repos.value?.let {
                    RepoItems(it, this::clickRepoItem)
                } ?: RepoLoading()
            }
        }

        val query = intent.getStringExtra(EXTRA_QUERY) ?: throw IllegalArgumentException()
        viewModel.fetch(query)
    }

    private fun clickRepoItem(repo: Repo) {
        Timber.d("repo: $repo")
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(repo.url))
        startActivity(intent)
    }

    companion object {
        private const val EXTRA_QUERY = "query"

        fun createIntent(context: Context, query: String) = Intent(context, ReposActivity::class.java).apply {
            putExtra(EXTRA_QUERY, query)
        }
    }
}
