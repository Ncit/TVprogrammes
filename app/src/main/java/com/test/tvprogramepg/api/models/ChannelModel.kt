package com.test.tvprogramepg.api.models

import androidx.recyclerview.widget.DiffUtil
import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root


@Root(strict = false, name = "channel")
data class ChannelModel(
    @field:Element(name = "icon", required = false)
    var icon: IconModel? = null,
    @field:Element(name = "display-name",required = false)
    var name: String? = null,
    @field:Attribute(name = "idNo", required = false)
    var idNo: String? = null,
    @field:Attribute(name = "id", required = false)
    var id: String? = null)
{
    companion object
    {
        val callback: DiffUtil.ItemCallback<ChannelModel> = object : DiffUtil.ItemCallback<ChannelModel>() {
            override fun areItemsTheSame(channel: ChannelModel, t1: ChannelModel): Boolean {
                return channel.id === t1.id
            }

            override fun areContentsTheSame(channels: ChannelModel, t1: ChannelModel): Boolean {
                return true
            }
        }
    }

}