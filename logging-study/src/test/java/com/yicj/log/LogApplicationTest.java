package com.yicj.log;


import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LogApplicationTest {

   private Logger logger = LoggerFactory.getLogger(LogApplicationTest.class) ;


   public void testHello(){

   }

}
