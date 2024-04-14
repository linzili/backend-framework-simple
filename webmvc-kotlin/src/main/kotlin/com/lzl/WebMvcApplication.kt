package com.lzl

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.TimeUnit


@SpringBootApplication
class WebMvcApplication

fun main(args: Array<String>) {
    runApplication<WebMvcApplication>(*args)
}


@RestController
class TestController {

    @GetMapping("hello")
    fun test() {
        TimeUnit.MILLISECONDS.sleep(100)
        println("hello mvc")
    }
}
