package com.mapstructplus

import com.mapstructplus.dto.CarDto
import com.mapstructplus.dto.UserDto
import com.mapstructplus.entity.Car
import com.mapstructplus.entity.SeatConfiguration
import com.mapstructplus.entity.User
import io.github.linpeilie.Converter
import jakarta.annotation.Resource
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class Test {


    @Resource
    lateinit var converter: Converter

    /**
     * 自定义类型转换器
     *
     */
    @Test
    fun test() {
        val user = User("张三", 18, "daxve,123")
        val userDto = converter.convert(user, UserDto::class.java)
        assert(userDto.username == user.username)
        assert(userDto.age == user.age)
        println(userDto.educationList)
    }


    /**
     * 自定义对象的属性自动转换
     *
     */
    @Test
    fun automaticPropertyConversion() {
        val car = Car(SeatConfiguration(1L))
        val carDto = converter.convert(car, CarDto::class.java)
        assert(car.seatConfiguration.id == carDto.seatConfigurationDto.id)
    }
}
