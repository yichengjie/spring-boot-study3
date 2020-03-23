package com.yicj.api.event;

import java.util.Set;

public interface EventExecutor {

    Set<String> supportTags() ;

    void handleEvent(StatusChangedEvent event) ;
}
