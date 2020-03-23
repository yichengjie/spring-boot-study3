package com.yicj.api.event;

import com.yicj.api.BootstrapApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= BootstrapApp.class)
public class ListenerTest {

    @Autowired
    private EventHandler eventHandler ;


    @Test
    public void testListener(){
        StatusChangedEvent event = new StatusChangedEvent() ;
        event.setTopic("default");
        event.setTag(EventConstant.INSERT);
        event.setContent("content");
        eventHandler.handleEvent(event);
    }
}
