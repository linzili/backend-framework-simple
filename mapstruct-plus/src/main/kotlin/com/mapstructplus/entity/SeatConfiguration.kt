package com.mapstructplus.entity

import com.mapstructplus.dto.SeatConfigurationDto
import io.github.linpeilie.annotations.AutoMapper


@AutoMapper(target = SeatConfigurationDto::class)
data class SeatConfiguration(
    val id: Long
)
