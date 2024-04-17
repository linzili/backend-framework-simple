package com.satoken.dto

import com.satoken.enums.GenderEnum
import com.satoken.enums.SourceEnum
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "测试DTO")
data class TestDto(
    val sourceEnum: SourceEnum
)
