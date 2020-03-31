package com.yicj.api.hello.abstra;

public abstract class Animal {

    public void execute(){
        System.out.println("Animal execute start ....");
        this.hello();
        System.out.println("Animal execute end ....");
    }

    public void hello(){
        System.out.println("Animal hello");
    }

}
