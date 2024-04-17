package com.satoken.controller

import com.satoken.enums.GenderEnum
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("enum")
class EnumController {

    @GetMapping
    fun getGender(gender: GenderEnum) = gender.name
}
