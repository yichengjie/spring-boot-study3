package com.yicj.exception.demo3;

import java.io.IOException;
import java.net.ServerSocket;

//测试springboot启动端口被占用时的异常
public class MySocket {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8080);
        serverSocket.accept() ;

    }
}
