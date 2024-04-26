package com.mapstructplus.entity

import io.github.linpeilie.annotations.AutoMapping
import java.util.*

open class BaseEntity(

    @AutoMapping(dateFormat = "yyyy-MM-dd")
    var createTime: Date? = null,
    var updateTime: Date? = null,
    var createBy: String? = null,
    var updateBy: String? = null,
    var delFlag: Int? = null,
    var remark: String? = null
)
