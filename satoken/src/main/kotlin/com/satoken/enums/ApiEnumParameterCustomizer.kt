package com.satoken.enums

import io.swagger.v3.oas.models.media.Schema
import io.swagger.v3.oas.models.parameters.Parameter
import org.springdoc.core.customizers.ParameterCustomizer
import org.springframework.core.MethodParameter
import org.springframework.stereotype.Component

/**
 * 枚举参数自定义配置
 */
@Component
class ApiEnumParameterCustomizer : ParameterCustomizer, BasicEnumCustomizer {

    override fun customize(parameterModel: Parameter?, methodParameter: MethodParameter): Parameter? {
        val parameterType = methodParameter.parameterType
        if (parameterModel != null) {
            // 枚举处理
            if (BasicEnum::class.java.isAssignableFrom(parameterType)) {
                parameterModel.description = getDescription(parameterType)
                val schema = Schema<Any>()
                schema.enum = getValues(parameterType)
                parameterModel.schema = schema
            }
        }
        return parameterModel
    }
}
