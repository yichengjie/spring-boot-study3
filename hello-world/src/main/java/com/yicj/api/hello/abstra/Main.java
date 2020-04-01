package com.yicj.api.hello.abstra;

import java.lang.reflect.Constructor;

public class Main {


    public Main(){}

    public Main(String str){

    }

    public static void main(String[] args) throws NoSuchMethodException {
        //Animal animal = new Dog() ;
        //animal.execute();
        Class<?> clazz = Main.class ;

        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
        System.out.println();


    }
}
