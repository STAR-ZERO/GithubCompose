package com.star_zero.githubcompose.repos

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.star_zero.githubcompose.data.GithubAPI
import com.star_zero.githubcompose.data.Repo
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.Executors

class ReposViewModel: ViewModel() {
    val api: GithubAPI

    val repos = MutableLiveData<List<Repo>>()

    init {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory()) // kaptがうまくいかないのでしょうがなく...
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        api = retrofit.create(GithubAPI::class.java)
    }

    fun fetch(query: String) {
        val executors = Executors.newSingleThreadExecutor()
        // lambda式を使うとビルド通らない
        executors.submit(object : Runnable {
            override fun run() {
                val res = api.searchRepo(query).execute().body()
                repos.postValue(res?.items)
            }
        })
    }
}
