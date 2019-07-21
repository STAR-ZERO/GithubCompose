package com.star_zero.githubcompose.repos

import androidx.compose.*
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.Clickable
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.layout.EdgeInsets
import androidx.ui.layout.Row
import androidx.ui.layout.VerticalScroller
import androidx.ui.material.Divider
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.surface.Card
import com.star_zero.githubcompose.data.Repo
import timber.log.Timber

@Composable
fun RepoLoading() {
    Column {
        Container(padding = EdgeInsets(16.dp)) {
            Text(
                text = "Loading..."
            )
        }
    }
}

@Composable
fun RepoItems(repos: List<Repo>, clickItem: (Repo) -> Unit) {
    VerticalScroller {
        Column {
            repos.forEach { repo ->
                RepoItem(repo, clickItem)
            }
        }
    }
}

@Composable
fun RepoItem(repo: Repo, clickItem: (Repo) -> Unit) {
    Card {
        Ripple(bounded = true) {
            // ClickableがContainerの中にあると感度が悪い気がする
            Clickable(onClick = { clickItem(repo) }) {
                Container(padding = EdgeInsets(16.dp)) {
                    Row {
                        Text(text = repo.fullName)
                    }
                }
            }
        }
    }
    Divider(color = Color(0xFFC6C6C6.toInt()))
}
