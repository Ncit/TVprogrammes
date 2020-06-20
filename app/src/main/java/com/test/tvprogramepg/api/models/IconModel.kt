package com.test.tvprogramepg.api.models

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(strict = false, name = "icon")
data class IconModel (
    @field:Attribute(name = "src", required = false)
    var src: String? = null
)