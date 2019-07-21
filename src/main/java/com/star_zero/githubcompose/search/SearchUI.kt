package com.star_zero.githubcompose.search

import androidx.compose.Composable
import androidx.compose.onActive
import androidx.compose.onCommit
import androidx.compose.onDispose
import androidx.compose.onPreCommit
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.InputField
import androidx.ui.layout.Center
import androidx.ui.layout.Column
import androidx.ui.material.Button
import androidx.ui.core.sp
import androidx.ui.text.TextStyle
import androidx.ui.input.EditorState
import androidx.ui.input.KeyboardType
import androidx.ui.core.EditorStyle
import androidx.ui.core.dp
import androidx.ui.layout.Container
import androidx.ui.layout.EdgeInsets
import timber.log.Timber

@Composable
fun SearchForm(clickSearch: (String) -> Unit) {
    val query = +state { EditorState(text = "android") }

    Center {
        Column {
            Container(padding = EdgeInsets(16.dp)) {
                InputField(
                    value = query.value,
                    keyboardType = KeyboardType.Text,
                    onValueChange = { query.value = it },
                    editorStyle = EditorStyle(textStyle = TextStyle(fontSize = 24.sp))
                )
            }
            Button(
                text = "Search",
                onClick = {
                    clickSearch(query.value.text)
                }
            )
        }
    }
}