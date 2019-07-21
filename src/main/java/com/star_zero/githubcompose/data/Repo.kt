package com.star_zero.githubcompose.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class RepoResponse(
    @Json(name = "items")
    val items: List<Repo>
)

data class Repo(
    @Json(name = "full_name")
    val fullName: String,
    @Json(name = "html_url")
    val url: String
)
