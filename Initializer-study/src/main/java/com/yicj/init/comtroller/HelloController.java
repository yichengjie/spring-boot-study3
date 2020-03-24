package com.yicj.init.comtroller;

import com.yicj.init.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private HelloService helloService ;

    @GetMapping("/test1")
    public String test1(){
        return helloService.test1();
    }

    @GetMapping("/test2")
    public String test2(){
        return helloService.test2();
    }

    @GetMapping("/test3")
    public String test3(){
        return helloService.test3();
    }
}
