package com.yicj.starter.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
//@MyConditionalAnnotation("com.mooc.condition")
@MyConditionalAnnotation({"hello","world"})
public class A {

}
