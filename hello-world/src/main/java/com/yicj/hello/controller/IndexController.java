package com.yicj.hello.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ConfigurationProperties
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        System.out.println("==========> hello ");
        return "index" ;
    }
}
