package com.wm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wm on 2017/8/12.
 */
@RestController
@RequestMapping("/web")
public class HelloController {

    @RequestMapping(value = "/say_hello", method = RequestMethod.GET)
    public String hello(@RequestParam("name")  String name) {
        return "hello," + name + "!";
    }
}

