package com.yicj.api.event;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class SecondExecutor implements EventExecutor {
    @Override
    public Set<String> supportTags() {
        return new HashSet<String>(){{
            add(EventConstant.QUERY) ;
            add(EventConstant.INSERT) ;
        }};
    }

    @Override
    public void handleEvent(StatusChangedEvent event) {
        System.out.println("second " + event.getContent());
    }
}
