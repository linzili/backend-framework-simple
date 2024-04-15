package com.mybatisflux

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@MapperScan("com.mybatisflux.mapper")
class Application


fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
