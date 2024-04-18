package com.satoken.dto

import com.satoken.enums.GenderEnum
import com.satoken.enums.SourceEnum
import io.swagger.v3.oas.annotations.media.Schema

@Schema(title = "ceshidto")
data class TestDto(

    @Schema(title = "123", description = "123")
    val sourceEnum: SourceEnum
)
