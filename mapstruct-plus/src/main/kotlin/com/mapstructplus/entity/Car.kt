package com.mapstructplus.entity

import com.mapstructplus.dto.CarDto
import io.github.linpeilie.annotations.AutoMapper
import io.github.linpeilie.annotations.AutoMapping

@AutoMapper(target = CarDto::class)
data class Car(

    @AutoMapping(target = "seatConfigurationDto")
    var seatConfiguration: SeatConfiguration
)
