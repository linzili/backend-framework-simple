package com.mapstructplus

import com.mapstructplus.dto.BaseDto
import com.mapstructplus.dto.UserDto
import com.mapstructplus.entity.User
import io.github.linpeilie.Converter
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class Test {


    @Autowired
    lateinit var converter: Converter

    @Test
    fun test() {
        val user = User("张三", 18)
//        val userDto = converter.convert(user, UserDto::class.java)
        val userDto = UserDto(12, 0)
        val base = BaseDto()
        base.username

        userDto.username
        println(userDto.username)

    }
}
