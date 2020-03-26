package com.yicj.property.ex;

public class Main {

    public static void main(String[] args) {
        try {
            throw new CException(new BException(new AException(new Exception("test")))) ;
        } catch (Throwable e) {
            while (e != null){
                System.out.println(e.getClass());
                e = e.getCause() ;
            }
        }

    }
}
