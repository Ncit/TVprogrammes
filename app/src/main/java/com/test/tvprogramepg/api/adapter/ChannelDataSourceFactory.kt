package com.test.tvprogramepg.api.adapter

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.test.tvprogramepg.api.models.ChannelModel

class ChannelDataSourceFactory : DataSource.Factory<Long, ChannelModel>() {

    var channelDataSource: ChannelsDataSource = ChannelsDataSource()
    var mutableLiveData: MutableLiveData<ChannelsDataSource> = MutableLiveData()

    override fun create(): DataSource<Long, ChannelModel> {
        mutableLiveData.postValue(channelDataSource)
        return channelDataSource
    }

}