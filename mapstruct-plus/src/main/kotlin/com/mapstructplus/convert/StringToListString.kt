package com.mapstructplus.convert

import org.springframework.stereotype.Component

@Component
class StringToListString {
    fun stringToListString(source: String) = source.split(",")
}
