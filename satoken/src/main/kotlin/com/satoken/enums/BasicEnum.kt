package com.satoken.enums

import com.fasterxml.jackson.annotation.JsonValue
import com.satoken.enums.BasicEnum.Companion.fromValue
import java.io.Serializable

interface BasicEnum<V : Serializable, E : Enum<E>> {

    @get:JsonValue
    val value: V

    companion object {
        inline fun <reified B, V> Class<B>.fromValue(value: V): B?
                where B : BasicEnum<V, *>, V : Serializable, B : Enum<B> {
            return enumConstants?.asSequence()
                ?.filter { it.value == value }
                ?.firstOrNull()
        }
    }
}
