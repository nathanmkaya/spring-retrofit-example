package com.mobidev.billing.github

import com.mobidev.billing.model.Repo
import com.mobidev.billing.model.Response
import io.reactivex.Observable
import org.apache.log4j.Logger
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory

class Client {

    companion object {
        val BASE_URL : String = "https://api.github.com"
        var result : List<Repo>? = null
        val log = Logger.getLogger(Client::class.simpleName)

        fun getRepos(query: String): List<Repo?>? {
            println("Called")
            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            val github = retrofit.create(API::class.java)

            github.repos(query)

            github.repos(query).subscribe(
                    {t: Response? -> result= t?.repos as List<Repo>? },
                    { error -> println(error)},
                    { println("Success")}
            )


            return result
        }

        fun getReposAsync(query: String) : Observable<Response> {
            log.info("Client Called")
            log.info("query parameter $query")
            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            val github = retrofit.create(API::class.java)

            return github.repos(query)
        }
    }
}