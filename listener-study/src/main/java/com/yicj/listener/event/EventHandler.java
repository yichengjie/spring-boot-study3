package com.yicj.listener.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class EventHandler implements ApplicationListener<ContextRefreshedEvent> {

    private final Map<String, Set<EventExecutor>> executorMap = new HashMap<>() ;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        synchronized (executorMap){
            ApplicationContext ac = event.getApplicationContext();
            Map<String, EventExecutor> beansOfType = ac.getBeansOfType(EventExecutor.class);
            if (beansOfType == null || beansOfType.isEmpty()) {
                return;
            }
            for (EventExecutor executor: beansOfType.values()){
                Set<String> tags = executor.supportTags();
                for (String tag: tags){
                    if(executorMap.containsKey(tag)){
                        executorMap.get(tag).add(executor) ;
                    }else {
                        Set<EventExecutor> set = new HashSet<>() ;
                        set.add(executor) ;
                        executorMap.put(tag,set) ;
                    }

                }
            }

        }

    }
    public void handleEvent(StatusChangedEvent event){
        Set<EventExecutor> eventExecutors = executorMap.get(event.getTag());
        eventExecutors.forEach(executor -> executor.handleEvent(event));
    }
}