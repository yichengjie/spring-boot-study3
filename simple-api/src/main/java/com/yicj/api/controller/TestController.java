package com.yicj.api.controller;

import com.yicj.api.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService ;

    @GetMapping("/test1")
    public String test1(){
        return testService.test1();
    }

    @GetMapping("/test2")
    public String test2(){
        return testService.test2();
    }

    @GetMapping("/test3")
    public String test3(){
        return testService.test3();
    }
}
