package com.test.tvprogramepg.api.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.test.tvprogramepg.api.models.ChannelModel
import com.test.tvprogramepg.databinding.ChannelLayoutBinding

class TVAdapter : PagedListAdapter<ChannelModel,ChannelViewHolder>(ChannelModel.callback)  {

    var clickPositionListener: ((channelId: String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemPersonBinding = ChannelLayoutBinding.inflate(layoutInflater, parent, false)
        return ChannelViewHolder(itemPersonBinding)
    }

    override fun onBindViewHolder(holder: ChannelViewHolder, position: Int) {
        getItem(position)?.apply {
            holder.bind(this)
            this.idNo?.let {
                holder.setListener {
                    clickPositionListener?.invoke(it)
                }
            }
        }
    }
}