package com.wang.swagger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2021/10/16 0016
 */

@RestController
public class helloController {

    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello";
    }
}
