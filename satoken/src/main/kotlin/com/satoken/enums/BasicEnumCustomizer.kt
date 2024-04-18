package com.satoken.enums

import io.swagger.v3.core.util.PrimitiveType
import io.swagger.v3.oas.models.media.ObjectSchema
import io.swagger.v3.oas.models.media.Schema
import org.springframework.beans.BeanUtils
import org.springframework.util.ReflectionUtils
import java.lang.reflect.Modifier
import java.lang.reflect.Type

interface BasicEnumCustomizer {

    /**
     * 获取枚举的所有值
     *
     * @param enumClazz 枚举的class
     * @return 枚举的所有值
     */
    fun getValues(enumClazz: Class<*>): List<Any> {
        return enumClazz.enumConstants
            .mapNotNull { item ->
                // 收集values
                val getValue = ReflectionUtils.findMethod(item.javaClass, "getValue")
                getValue?.let {
                    ReflectionUtils.makeAccessible(it)
                    ReflectionUtils.invokeMethod(it, item)
                }
            }
    }

    /**
     * 获取值和描述对应的描述信息，值和描述信息以“:”隔开
     *
     * @param enumClazz 枚举class
     * @return 描述信息
     */
    fun getDescription(enumClazz: Class<*>): String {
        val fieldList = enumClazz.declaredFields
            .filter { !Modifier.isStatic(it.modifiers) }
            .sortedByDescending { it.name }

        fieldList.forEach { ReflectionUtils.makeAccessible(it) }

        return enumClazz.enumConstants
            .filterNotNull().joinToString("； ") { item ->
                fieldList.joinToString(" : ") { field ->
                    field.get(item).toString()
                }
            }
    }

    /**
     * 根据枚举值的类型获取对应的 {@link Schema} 类
     *  这么做是因为当SpringDoc获取不到属性的具体类型时会自动生成一个string类型的 {@link Schema} ，
     *  所以需要根据枚举值的类型获取不同的实例，例如 {@link io.swagger.v3.oas.models.media.IntegerSchema}、
     *  {@link io.swagger.v3.oas.models.media.StringSchema}
     *
     * @param type         枚举值的类型
     * @param sourceSchema 从属性中加载的 {@link Schema} 类
     * @return 获取枚举值类型对应的 {@link Schema} 类
     */
    fun getSchemaByType(type: Type, sourceSchema: Schema<*>): Schema<Any> {
        val schema = PrimitiveType.fromType(type)?.createProperty()
            ?: ObjectSchema()

        // 获取schema的type和format
        val schemaType = schema.type
        val format = schema.format

        // 复制原schema的其它属性
        BeanUtils.copyProperties(sourceSchema, schema)

        // 使用根据枚举值类型获取到的schema
        return schema.type(schemaType).format(format)
    }
}
