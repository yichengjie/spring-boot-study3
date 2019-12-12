package com.yicj.api.component;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("database")
@Data
public class DatabaseProperties {
    private String driverName ;
    private String url ;
    private String username ;
    private String password ;
}

