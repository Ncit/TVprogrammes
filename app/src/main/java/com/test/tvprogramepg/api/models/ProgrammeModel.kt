package com.test.tvprogramepg.api.models

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(strict = false, name = "programme")
data class ProgrammeModel(
    @field:Attribute(name = "start", required = false)
    var start: String? = null,

    @field:Attribute(name = "stop", required = false)
    var stop: String? = null,

    @field:Attribute(name = "channel", required = false)
    var channel: String? = null,

    @field:Attribute(name = "idNo", required = false)
    var idNo: String? = null,

    @field:Element(name = "title", required = false)
    var title: String? = null,

    @field:Element(name = "sub-title",required = false)
    var subTitle: String? = null,

    @field:Element(name = "category",required = false)
    var category: String? = null,

    @field:Element(name = "desc",required = false)
    var desc: String? = null,

    @field:Element(name = "icon", required = false)
    var icon: IconModel? = null
)