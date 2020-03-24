package com.yicj.listener.event;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class FirstExecutor implements EventExecutor {
    @Override
    public Set<String> supportTags() {
        return new HashSet<String>(){{
            add(EventConstant.DELETE) ;
            add(EventConstant.UPDATE) ;
        }};
    }

    @Override
    public void handleEvent(StatusChangedEvent event) {
        System.out.println("first " + event.getContent());
    }
}
