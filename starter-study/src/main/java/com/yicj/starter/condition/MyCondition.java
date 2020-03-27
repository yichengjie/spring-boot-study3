package com.yicj.starter.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Arrays;


public class MyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String annotationName = "com.yicj.starter.condition.MyConditionalAnnotation" ;
        String [] value = (String[])metadata.getAnnotationAttributes(annotationName).get("value");
        System.out.println("===> "+ Arrays.asList(value));
//        for (String v : value){
//            if (StringUtils.isEmpty(context.getEnvironment().getProperty(v))){
//                return false ;
//            }
//            System.out.println(v);
//        }
        return true;
    }
}
