package com.yicj.api.component;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import java.util.HashMap;
import java.util.Map;

@Order(3)
public class ThirdInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>{

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        Map<String,Object> map = new HashMap<>() ;
        map.put("key3","value3") ;
        MapPropertySource mapPropertySource = new MapPropertySource("thirdInitializer", map);
        environment.getPropertySources().addLast(mapPropertySource) ;
        System.out.println("====> running thirdInitializer");
    }
}
