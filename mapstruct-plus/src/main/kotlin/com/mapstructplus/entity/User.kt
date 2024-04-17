package com.mapstructplus.entity

import com.mapstructplus.dto.UserDto
import io.github.linpeilie.Converter
import io.github.linpeilie.annotations.AutoMapper


@AutoMapper(target = UserDto::class)
data class User(
    val username: String,
    val age: Int
)

