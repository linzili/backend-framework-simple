package com.satoken.enums


import com.fasterxml.jackson.databind.type.SimpleType
import io.swagger.v3.core.converter.AnnotatedType
import io.swagger.v3.oas.models.media.Schema
import org.springdoc.core.customizers.PropertyCustomizer
import org.springframework.stereotype.Component
import org.springframework.util.ObjectUtils
import java.lang.reflect.ParameterizedType

/**
 * 枚举属性自定义配置
 */
@Component
class ApiEnumPropertyCustomizer : PropertyCustomizer, BasicEnumCustomizer {

    override fun customize(property: Schema<*>, type: AnnotatedType): Schema<*> {
        // 检查实例并转换
        if (type.type is SimpleType) {
            // 获取字段class
            val fieldClazz = (type.type as SimpleType).rawClass
            // 是否是枚举
            if (BasicEnum::class.java.isAssignableFrom(fieldClazz)) {
                // 获取父接口
                val genericInterfaces = fieldClazz.genericInterfaces
                if (genericInterfaces.isNotEmpty() && genericInterfaces[0] is ParameterizedType) {
                    // 通过父接口获取泛型中枚举值的class类型
                    val actualTypeArgument = (genericInterfaces[0] as ParameterizedType).actualTypeArguments[0]
                    val schema = getSchemaByType(actualTypeArgument, property)

                    // 重新设置字段的注释和默认值
                    schema.enum = this.getValues(fieldClazz)

                    // 获取字段注释
                    val description = this.getDescription(fieldClazz)

                    // 重置字段注释和标题为从枚举中提取的
//                    schema.title = if (ObjectUtils.isEmpty(property.title)) description else "${property.title} ($description)"
                    schema.description = if (ObjectUtils.isEmpty(property.description)) description else "${property.description} ($description)"
                    return schema
                }
            }
        }
        return property
    }
}
