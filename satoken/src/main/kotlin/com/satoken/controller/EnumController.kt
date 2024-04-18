package com.satoken.controller

import com.satoken.dto.TestDto
import com.satoken.enums.SourceEnum
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("enum")
class EnumController {

    @PostMapping
    fun getGender(@RequestBody dto: TestDto) = dto.sourceEnum

    @GetMapping
    fun test1(enum: SourceEnum) = enum
}
