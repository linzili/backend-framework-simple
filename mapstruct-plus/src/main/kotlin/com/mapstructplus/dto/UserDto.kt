package com.mapstructplus.dto

import com.mapstructplus.entity.User
import io.github.linpeilie.annotations.AutoMapper

@AutoMapper(target = User::class)
data class UserDto(
    val age: Int,
    var gender:Int?
):BaseDto()
