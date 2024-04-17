package com.satoken.controller

import com.satoken.dto.TestDto
import com.satoken.enums.GenderEnum
import com.satoken.enums.SourceEnum
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("enum")
class EnumController {

//    @PostMapping
//    fun getGender(@RequestBody gender: TestDto) = gender.genderEnum


    @PostMapping("test")
    fun test(@RequestBody source:TestDto) = source
}
