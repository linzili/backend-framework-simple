package com.mapstructplus.dto

import com.mapstructplus.entity.Order
import io.github.linpeilie.annotations.AutoMapper
import io.github.linpeilie.annotations.AutoMapping
import java.time.LocalDate


@AutoMapper(target = Order::class)
data class OrderDto(
    var orderTime: String,

    var createTime: String,

    @AutoMapping(target = "date", dateFormat = "yyyy-MM-dd")
    var orderDate: LocalDate,

    @AutoMapping(numberFormat = "$0.00")
    var orderPrice: String,

    @AutoMapping(numberFormat = "$0.00")
    var goodsNum: String

)
