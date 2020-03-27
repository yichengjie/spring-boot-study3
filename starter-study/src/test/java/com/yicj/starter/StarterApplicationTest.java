package com.yicj.starter;

import com.yicj.starter.condition.A;
import com.yicj.weather.WeatherService;
import com.yicj.weather.WeatherSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StarterApplicationTest {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private WeatherService weatherService ;

    @Autowired
    private WeatherSource weatherSource ;


    @Test
    public void testGetA(){
        A bean = context.getBean(A.class);
        System.out.println(bean);
    }

    @Test
    public void getWeatherService(){
        String info = "type : " + weatherService.getType()
                +", rate : " + weatherService.getRate() ;
        System.out.println("======> " + info);
    }

    @Test
    public void getWeatherSource(){
        String info = "type : " + weatherSource.getType()
                +", rate : " + weatherSource.getRate() ;
        System.out.println("======> " + info);
    }

}
