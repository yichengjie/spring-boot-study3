package com.yicj.starter.condition;

import org.springframework.context.annotation.Conditional;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE})
@Documented
@Conditional(MyCondition.class)
public @interface MyConditionalAnnotation {

    String[] value() default {};
}
