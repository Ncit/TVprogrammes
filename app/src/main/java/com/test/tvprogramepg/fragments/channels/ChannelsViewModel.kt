package com.test.tvprogramepg.fragments.channels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.test.tvprogramepg.adapter.ChannelDataSourceFactory
import com.test.tvprogramepg.adapter.ChannelsDataSource
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
            .setInitialLoadSizeHint(8)
            .setPageSize(8)
            .setPrefetchDistance(29)
            .build()
        executor = Executors.newFixedThreadPool(5)
        pagedListLiveData =
            LivePagedListBuilder(channelDataSourceFactory, config)
                .setFetchExecutor(executor)
                .build()
    }
}