package com.mapstructplus.dto

import java.util.*

open class BaseDto(
    var createTime: String? = null,
    var updateTime: Date? = null,
    var createBy: String? = null,
    var updateBy: String? = null,
    var delFlag: Int? = null,
    var remark: String? = null
)
