package com.yicj.log.exception;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionAspect {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionAspect.class) ;

    @AfterThrowing(pointcut = "within(com.yicj.log..*)", throwing = "ex")
    public void handleException(JoinPoint joinPoint, Exception ex) throws Exception{
        Class declaringType = joinPoint.getSignature().getDeclaringType();
        String clazz = declaringType.getCanonicalName();
        String name = joinPoint.getSignature().getName();
        if (ex instanceof BusinessException){
            logger.warn("clazz:{},name:{}",clazz,name,ex);
        }else if(ex instanceof SystemException){
            logger.error("clazz:{}, name :{}", clazz, name, ex);
        }
        throw ex ;
    }

}
