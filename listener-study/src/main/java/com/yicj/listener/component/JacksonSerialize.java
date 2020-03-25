package com.yicj.listener.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JacksonSerialize implements SerializedInterface {
    @Override
    public String serialize(Object object) {
        try {
            System.out.println("JacksonSerialize ...");
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e) ;
        }
    }
}
