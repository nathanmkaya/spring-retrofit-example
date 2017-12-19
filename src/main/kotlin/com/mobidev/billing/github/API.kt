package com.mobidev.billing.github

import com.mobidev.billing.model.Response
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface API {
    @GET("/search/repositories")
    fun repos(@Query("q") query: String): Observable<Response>
}