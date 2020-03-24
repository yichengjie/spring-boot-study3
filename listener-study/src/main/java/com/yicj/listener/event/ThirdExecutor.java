package com.yicj.listener.event;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ThirdExecutor implements EventExecutor {
    @Override
    public Set<String> supportTags() {
        return new HashSet<String>(){{
            add(EventConstant.DELETE) ;
            add(EventConstant.INSERT) ;
        }};
    }

    @Override
    public void handleEvent(StatusChangedEvent event) {
        System.out.println("third " + event.getContent());
    }
}
