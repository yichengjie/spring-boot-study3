package com.yicj.property;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@TestPropertySource({"demo.properties"})
@SpringBootTest(properties = {"mooc.website.url=mooc_url_9"})
public class PropertyApplicationTest {

    @Test
    public void contextLoads(){

    }
}
