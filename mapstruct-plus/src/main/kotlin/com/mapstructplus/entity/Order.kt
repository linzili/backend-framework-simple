package com.mapstructplus.entity

import com.mapstructplus.dto.OrderDto
import io.github.linpeilie.annotations.AutoMapper
import io.github.linpeilie.annotations.AutoMapping
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*


@AutoMapper(target = OrderDto::class)
data class Order(

    @AutoMapping(dateFormat = "yyyy-MM-dd HH:mm:ss")
    var orderTime: LocalDateTime,

    @AutoMapping(dateFormat = "yyyy_MM_dd HH:mm:ss")
    var createTime: Date,

    @AutoMapping(target = "orderDate", dateFormat = "yyyy-MM-dd")
    var date: String,

    @AutoMapping(numberFormat = "$0.00")
    var orderPrice: BigDecimal,

    @AutoMapping(numberFormat = "$0.00")
    var goodsNum: Int
)
