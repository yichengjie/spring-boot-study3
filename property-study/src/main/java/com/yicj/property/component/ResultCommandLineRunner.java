package com.yicj.property.component;

import com.yicj.property.aware.Flag;
import com.yicj.property.aware.MyAware;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ResultCommandLineRunner implements CommandLineRunner, EnvironmentAware , MyAware {
    private Flag flag ;
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
        System.out.println("====>  flag canOperate : " + this.flag.isCanOperate());
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment ;
    }

    @Override
    public void setFlag(Flag flag) {
        this.flag = flag ;
    }
}
