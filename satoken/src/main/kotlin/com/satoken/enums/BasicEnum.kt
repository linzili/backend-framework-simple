package com.satoken.enums

import com.fasterxml.jackson.annotation.JsonValue
import com.satoken.enums.BasicEnum.Companion.fromValue
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

inline fun <reified B : BasicEnum<V>, V:Serializable> Class<BasicEnum<V>>.fromValue(value:V): B? {
      return  B::class.java.enumConstants.asSequence()
            .filter { it.value==value }
            .firstOrNull()
}


fun main() {
    println(SourceEnum::class.java.fromValue(1))
}
