package com.test.tvprogramepg.api.fragments.channels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.test.tvprogramepg.api.adapter.ChannelDataSourceFactory
import com.test.tvprogramepg.api.adapter.ChannelsDataSource
import com.test.tvprogramepg.api.models.ChannelModel
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class ChannelsViewModel : ViewModel() {

    var channelDataSourceFactory: ChannelDataSourceFactory = ChannelDataSourceFactory()
    var dataSourceMutableLiveData: MutableLiveData<ChannelsDataSource>
    private var executor: Executor
    var pagedListLiveData: LiveData<PagedList<ChannelModel>>

    init {
        dataSourceMutableLiveData = channelDataSourceFactory.mutableLiveData
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(5)
            .setPageSize(5)
            .setPrefetchDistance(5)
            .build()
        executor = Executors.newFixedThreadPool(5)
        pagedListLiveData =
            LivePagedListBuilder(channelDataSourceFactory, config)
                .setFetchExecutor(executor)
                .build()
    }
}