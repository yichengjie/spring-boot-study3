package com.yicj.listener.component;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

@Component
public class FastJsonSerialize implements SerializedInterface {
    @Override
    public String serialize(Object object) {
        System.out.println("FastJsonSerialize ... ");
        return JSON.toJSONString(object);
    }
}
