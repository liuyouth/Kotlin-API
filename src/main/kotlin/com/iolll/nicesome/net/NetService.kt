package com.iolll.nicesome.net

import com.iolll.nicesome.model.base.Result
import com.iolll.nicesome.model.base.SearchResult
import com.iolll.nicesome.model.entity.EchoSong

import io.reactivex.Observable

import retrofit2.http.GET
import retrofit2.http.Headers

import retrofit2.http.Query

import java.util.ArrayList

interface NetService {

    @GET("http://www.app-Echo.com/api/search/sound")
    fun search(@Query("keyword") name: String, @Query("page") page: Int, @Query("limit") limit: Int, @Query("src") src: Int): Observable<SearchResult<ArrayList<EchoSong>>>

    @Headers("X-Requested-With:XMLHttpRequest")
    @GET("http://www.app-echo.com/sound/api-infos")
    fun getId(@Query("ids") id: String): Observable<Result<ArrayList<EchoSong>>>

    companion object {
        val BASE_URL = "http://app.hxhz.com/"
    }
}
