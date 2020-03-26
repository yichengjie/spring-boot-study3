package com.yicj.config.selector;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyDeferredImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("===> MyDeferredImportSelector ....");
        return new String[]{"com.yicj.config.model.Teacher"};
    }
}
