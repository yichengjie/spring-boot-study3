package com.yicj.listener.component;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;

@Order(2)
public class SecondListener implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println("====> hello secondListener ...");
    }
}
