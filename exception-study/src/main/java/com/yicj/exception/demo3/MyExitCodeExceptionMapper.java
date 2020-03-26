package com.yicj.exception.demo3;

import org.springframework.boot.ExitCodeExceptionMapper;
import org.springframework.boot.web.embedded.tomcat.ConnectorStartFailedException;
import org.springframework.stereotype.Component;

//@Component
public class MyExitCodeExceptionMapper implements ExitCodeExceptionMapper {
    @Override
    public int getExitCode(Throwable exception) {
        if (exception instanceof ConnectorStartFailedException){
            return 10 ;
        }
        return 0;
    }
}
