package com.mapstructplus.dto

import com.mapstructplus.entity.User
import io.github.linpeilie.annotations.AutoMapper

@AutoMapper(target = User::class)
data class UserDto(
    var username: String,
    val age: Int,
    var gender: Int?,
    val educationList: List<String>
)
