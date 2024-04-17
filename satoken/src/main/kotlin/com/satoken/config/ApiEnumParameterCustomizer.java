package com.satoken.config;


import com.satoken.enums.BasicEnum;
import com.satoken.enums.BasicEnumCustomizer;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.customizers.ParameterCustomizer;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;

/**
 * 枚举参数自定义配置
 *
 * @author vains
 */
@Component
public class ApiEnumParameterCustomizer implements ParameterCustomizer, BasicEnumCustomizer {

    @Override
    public Parameter customize(Parameter parameterModel, MethodParameter methodParameter) {
        Class<?> parameterType = methodParameter.getParameterType();

        // 枚举处理
        if (BasicEnum.class.isAssignableFrom(parameterType)) {
            if(parameterModel==null) {
               parameterModel =  new Parameter();
            }
            parameterModel.setDescription(getDescription(parameterType));

            Schema<Object> schema = new Schema<>();
            schema.setEnum(getValues(parameterType));
            parameterModel.setSchema(schema);
        }

        return parameterModel;
    }
}

