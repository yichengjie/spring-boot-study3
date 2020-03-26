package com.yicj.config.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;


public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("===> MyImportSelector .....");
        return new String[]{"com.yicj.config.model.Student"};
    }
}
