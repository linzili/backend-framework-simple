package com.satoken.enums;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springdoc.core.annotations.ParameterObject;

/**
 * 来源枚举
 *
 * @author vains
 */

@Schema(description = "来源枚举")
public enum SourceEnum implements BasicEnum<Integer, SourceEnum> {

    /**
     * 1-web网站
     */
    WEB(1, "web网站"),

    /**
     * 2-APP应用
     */
    APP(2, "APP应用");

    /**
     * 来源代码
     */
    private final Integer value;

    /**
     * 来源名称
     */
    private final String source;

    SourceEnum(Integer value, String source) {
        this.value = value;
        this.source = source;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    public String getSource() {
        return this.source;
    }
}

