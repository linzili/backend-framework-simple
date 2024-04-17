package com.mybatisflex.test;

import com.mybatisflex.annotation.EnumValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum GenderEnum {
    AND(0, "and"),
    OR(1, "or");


    @EnumValue
    private final int code;
    private final String name;
}
