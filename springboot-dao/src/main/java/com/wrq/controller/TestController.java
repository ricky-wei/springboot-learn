package com.wrq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weiruiqi
 * @date 2019/10/8 15:31
 */
@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("test")
    public String test() {
        return "hello";
    }
}
