package com.yicj;

import com.yicj.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionApplicationTest {

    @Autowired
    private UserService demoService;

    @Test
    public void testWithoutTransaction() {
        demoService.addUser("tom");
    }
}
