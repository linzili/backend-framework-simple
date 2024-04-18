package com.satoken.controller

import com.satoken.dto.TestDto
import com.satoken.enums.SourceEnum
import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("enum")
class EnumController {

    @PostMapping
    fun getGender(@RequestBody dto: TestDto) = dto.sourceEnum

    @GetMapping
    fun test1(@NotNull(value = "不允许唯恐") enum: SourceEnum) = enum


    @GetMapping("str")
    fun test2(str: String) = str
}
