package com.test.tvprogramepg.api.adapter

import androidx.paging.PageKeyedDataSource
import com.test.tvprogramepg.DataHolder
import com.test.tvprogramepg.api.TVApi
import com.test.tvprogramepg.api.models.ChannelModel
import com.test.tvprogramepg.api.models.TvModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChannelsDataSource : PageKeyedDataSource<Long, ChannelModel>() {

    private val pageSize: Long = 5

    private var dataService: TVApi = TVApi.getService()

    var loadListener: (() -> Unit)? = null

    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<Long, ChannelModel>
    ) {
        val call = dataService.getChannels(0, pageSize)
        call?.enqueue(object : Callback<TvModel> {
            override fun onResponse(call: Call<TvModel>, response: Response<TvModel>) {
                if (response.isSuccessful) {
                    val body = response.body()
//                    DataHolder.programmes?.addAll(body?.programmes ?: arrayListOf())
                    callback.onResult(response.body()?.channels ?: listOf(), null, pageSize)
                    loadListener?.invoke()
                }
            }

            override fun onFailure(call: Call<TvModel>, t: Throwable) {
            }
        })
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, ChannelModel>) {
        val call = dataService.getChannels(params.key, params.key + pageSize)
        call?.enqueue(object : Callback<TvModel> {
            override fun onResponse(call: Call<TvModel>, response: Response<TvModel>) {
                if (response.isSuccessful) {
                    loadListener?.invoke()
                    val body = response.body()
//                    DataHolder.programmes?.addAll(body?.programmes ?: arrayListOf())
                    callback.onResult(response.body()?.channels  ?: listOf(), params.key + pageSize)
                }
            }

            override fun onFailure(call: Call<TvModel>, t: Throwable) {
            }
        })
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, ChannelModel>) {
    }
}