package com.star_zero.githubcompose.data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubAPI {
    @GET("search/repositories")
    fun searchRepo(@Query("q") query: String): Call<RepoResponse>

}