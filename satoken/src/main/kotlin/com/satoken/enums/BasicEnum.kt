package com.satoken.enums

import com.fasterxml.jackson.annotation.JsonValue
import java.io.Serializable

/**
 * 通用枚举接口
 *
 * @param <V> 枚举值的类型
 * @param <E> 子枚举类型
 */
interface BasicEnum<V : Serializable> {

    @get:JsonValue
    val value: V

    companion object {
        inline fun <reified B, V> Class<B>.fromValue(value: V): B?
                where B : BasicEnum<V>, V : Serializable {
            return enumConstants?.asSequence()
                ?.filter { it.value == value }
                ?.firstOrNull()
        }
    }
}
