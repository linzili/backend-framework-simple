package com.satoken.enums

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonValue


enum class GenderEnum(@JsonValue val value: Int, val label: String) {
    MALE(1, "男"),
    FEMALE(2, "女");
}
