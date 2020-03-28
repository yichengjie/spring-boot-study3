package com.yicj.webflux;

import org.junit.Test;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FluxHelloTest {

    @Test
    public void testReactor(){
        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5, 6);

        Mono<Integer> mono = Mono.just(1);

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6} ;

        Flux<Integer> arrFlux = Flux.fromArray(arr) ;

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        Flux<Integer> listFlux = Flux.fromIterable(list);

        Flux<Integer> fluxFlux = Flux.from(flux);

        Flux<Integer> streamFlux = Flux.fromStream(Stream.of(1, 2, 3, 4, 5, 6));

        //flux.subscribe() ;
        //arrFlux.subscribe(this::println) ;
        //listFlux.subscribe(this::println,this::println,()-> System.out.println("完成")) ;
        //streamFlux.subscribe(this::println,this::println,()-> System.out.println("完成"),subscription -> subscription.request(3)) ;
        streamFlux.subscribe(new DemoSubscriber()) ;
    }


    class DemoSubscriber extends BaseSubscriber<Integer>{
        @Override
        protected void hookOnSubscribe(Subscription subscription) {
            System.out.println("subscribe .... ");
            subscription.request(1);
        }

        @Override
        protected void hookOnNext(Integer value) {
            if (value == 4){
                cancel();
            }
            System.out.println("value = "+ value);
            request(1);
        }
    }



    private void println(Object obj){
        System.out.println(obj);
    }
}
