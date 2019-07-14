package com.michjony.basic.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * user:Cherie
 * datetime;2019/7/12 21:46
 */
@RestController
public class HelloController {


    @GetMapping(value = "/")
    public String hello() {
        return String.valueOf(new Random().nextInt(1000));
    }
}
