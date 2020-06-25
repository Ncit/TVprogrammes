package com.test.tvprogramepg.api

import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

object ServiceBuilder {

    private val baseUrl = "https://veusat-epg.azurewebsites.net/"
    private val okhttpClient = OkHttpClient.Builder().apply {
        this.addInterceptor { chain ->
            val request = chain.request()
            val response = chain.proceed(request)
            val body = response.body()
            body?.let {
                //hack to fix xml parse errors
                val value = it.string().replace("&","&#38;")
                return@addInterceptor response.newBuilder().body(ResponseBody.create(it.contentType(), value)).build()
            }

            return@addInterceptor response
        }
    }
    private val client = okhttpClient.build()


    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .build()

    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}