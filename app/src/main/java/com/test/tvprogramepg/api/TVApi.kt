package com.test.tvprogramepg.api

import com.test.tvprogramepg.api.models.TvModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TVApi {

    @GET("epg.php")
    fun getChannels(@Query("fromID") fromID: Long,@Query("toID") toID: Long): Call<TvModel>?

    companion object {
        fun getService(): TVApi {
            return ServiceBuilder.buildService(TVApi::class.java)
        }
    }
}