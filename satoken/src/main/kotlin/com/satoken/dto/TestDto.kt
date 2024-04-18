package com.satoken.dto

import com.satoken.enums.SourceEnum
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank

@Schema(title = "ceshidto")
data class TestDto(

    @Schema(title = "123", description = "123")
    val sourceEnum: SourceEnum,


    @NotBlank(message = "不允许唯恐")
    val name: String
)
