package com.yicj.log.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {

    @Autowired
    private UserHandler userHandler ;

    @Bean
    public RouterFunction<ServerResponse> userRouter(){
        return route(GET("/hello/{id}"),userHandler::hello);
    }
}
