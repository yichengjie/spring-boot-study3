package com.yicj.webflux.component;

import com.yicj.webflux.bean.User;
import com.yicj.webflux.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class UserHandler {
    @Autowired
    private UserMapper userMapper ;

    public Mono<ServerResponse> hello(ServerRequest request){
        return ok().contentType(MediaType.TEXT_PLAIN)
                .body(Mono.just("hello"),String.class) ;
    }

    public Mono<ServerResponse> world(ServerRequest request){
        return ok().contentType(MediaType.TEXT_PLAIN)
                .body(Mono.just("world"),String.class) ;
    }

    public Mono<ServerResponse> times(ServerRequest request){
        return ok().contentType(MediaType.TEXT_EVENT_STREAM)
                .body(Flux.interval(Duration.ofSeconds(1))
                        .map(it -> new SimpleDateFormat("hh:mm:ss").format(new Date())),String.class) ;
    }

    public Mono<ServerResponse> queryUser(ServerRequest request){
        Integer id = Integer.valueOf(request.pathVariable("id")) ;
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(userMapper.selectByPrimaryKey(id)), User.class) ;
    }
}
