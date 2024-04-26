package com.mapstructplus.entity

import com.mapstructplus.convert.StringToListString
import com.mapstructplus.dto.UserDto
import io.github.linpeilie.annotations.AutoMapper
import io.github.linpeilie.annotations.AutoMapping


@AutoMapper(target = UserDto::class, uses = [StringToListString::class])
data class User(
    val username: String,
    val age: Int,
    @AutoMapping(target = "educationList")
    val educations: String,
)

