package com.yicj.property.component;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ResultCommandLineRunner implements CommandLineRunner, EnvironmentAware {

    private Environment env ;
    @Override
    public void run(String... args) throws Exception {
        String url = env.getProperty("mooc.website.url");
        String age = env.getProperty("mooc.avg.age") ;
        String path = env.getProperty("mooc.website.path") ;
        String vmname = env.getProperty("mooc.vm.name") ;
        System.out.println("=====> mooc url is : " + url);
        System.out.println("=====> age : " + age);
        System.out.println("=====> path : " + path);
        System.out.println("=====> vmname : " + vmname);
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment ;
    }
}
