package com.mapstructplus.entity

import com.mapstructplus.vo.GoodsVo
import io.github.linpeilie.annotations.AutoMapper
import io.github.linpeilie.annotations.AutoMapping


@AutoMapper(target = GoodsVo::class)
data class Goods
    (
    @AutoMapping(source = "sku.price", target = "price")
    var sku: Sku,
)
