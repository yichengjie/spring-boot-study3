package com.yicj.exception.demo1;

public class ShutdownHookDemo {


    public static void main(String[] args) {
        Thread jvmShutdownHook = new Thread(()-> System.out.println("jvm shutdown ...")) ;
        Runtime.getRuntime().addShutdownHook(jvmShutdownHook);

    }
}
