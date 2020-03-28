package com.yicj.webflux;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.stream.Stream;

public class FluxApiTest {

    private Flux<Integer> flux ;
    private Flux<Integer> streamFlux ;
    private Logger logger = LoggerFactory.getLogger(FluxApiTest.class) ;

    @Before
    public void before(){
        flux = Flux.just(1, 2, 3, 4, 5, 6);
        streamFlux = Flux.fromStream(Stream.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void testMap(){
        flux.map(i -> i *3).subscribe(this::println) ;
    }


    @Test
    public void testFlatMap(){
        flux.flatMap(i -> flux).subscribe(this::println) ;
    }


    @Test
    public void testFilter(){
        flux.filter(i -> i < 4).subscribe(this::println) ;
    }

    @Test
    public void testZip(){
        Flux.zip(flux,streamFlux).subscribe(zip -> System.out.println(zip.getT1() + " , " + zip.getT2())) ;
    }

    @Test
    public void testPublish() throws InterruptedException {
        flux.map(i -> {
            System.out.println(Thread.currentThread().getName() +"-map1");
            return i *3 ;
        }).publishOn(Schedulers.elastic()).map(i -> {
            System.out.println(Thread.currentThread().getName() +"-map2");
            return i / 3 ;
        }).subscribeOn(Schedulers.parallel()).subscribe(it -> {
            String info = Thread.currentThread().getName() + "-> " + it ;
            System.out.println(info) ;
        }) ;
        Thread.sleep(2000);
    }


    private void println(Object obj){
        System.out.println(obj);
    }
}
