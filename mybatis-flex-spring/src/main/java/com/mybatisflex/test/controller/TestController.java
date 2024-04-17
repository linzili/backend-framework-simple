package com.mybatisflex.test.controller;

import com.mybatisflex.test.GenderEnum;
import com.mybatisflex.test.dto.EnumDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping
    public EnumDto test(@RequestBody EnumDto genderEnum) {
        return genderEnum;
    }
}
