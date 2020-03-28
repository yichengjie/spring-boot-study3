package com.yicj.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    @GetMapping("/user")
    public Mono<String> user(){

        return Mono.just("user") ;
    }

}
