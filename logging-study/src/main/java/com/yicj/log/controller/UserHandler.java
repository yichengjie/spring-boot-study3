package com.yicj.log.controller;

import com.yicj.log.exception.BusinessException;
import com.yicj.log.exception.SystemException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class UserHandler {

    public Mono<ServerResponse> hello(ServerRequest request){
        Integer id = Integer.valueOf(request.pathVariable("id")) ;
        if (id == 1){
            throw new BusinessException("can not use this id " + id) ;
        }else if (id == 2){
            throw new SystemException("can not use this id : " + id) ;
        }
        return ok().contentType(MediaType.TEXT_PLAIN)
                .body(Mono.just("hello"),String.class) ;
    }
}
