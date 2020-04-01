package com.yicj.ioc.ann;

import com.yicj.ioc.model.Dog;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class TestLookUp {

    @Lookup
    public abstract Dog getBean() ;


}
