package com.test.tvprogramepg.api.models

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(strict = false, name = "tv")
data class TvModel (

    @field:Attribute(name = "fromID", required = false)
    var fromID: String? = null,

    @field:Attribute(name = "toID", required = false)
    var toID: String? = null,

    @field:Attribute(name = "maxID", required = false)
    var maxID: String? = null,

    @field:ElementList(entry = "channel", type = ChannelModel::class, inline = true)
    var channels: List<ChannelModel>? = null
)