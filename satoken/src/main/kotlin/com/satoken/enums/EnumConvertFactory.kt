package com.satoken.enums

import org.springframework.core.convert.converter.Converter
import org.springframework.core.convert.converter.ConverterFactory
import org.springframework.stereotype.Component


@Component
class EnumConvertFactory : ConverterFactory<String, BasicEnum<*>> {
    override fun <T : BasicEnum<*>> getConverter(targetType: Class<T>): Converter<String, T> {
        return Converter { source ->
            return@Converter targetType.enumConstants.firstOrNull { it.value.toString() == source }
        }
    }
}
