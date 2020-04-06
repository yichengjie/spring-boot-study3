package com.yicj.api.hello.annos;


import org.springframework.context.annotation.Bean;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Set;

public class Main {


    public static void main(String[] args) throws IOException {

//        Class<?> clazz = MyConfig.class ;
//        clazz.getMet
//
//        Annotation[] annotations = clazz.getAnnotations();
//
//        for (Annotation annotation : annotations) {
//            System.out.println(annotation.getClass().getName());
//        }

        //SimpleMetadataReader metadataReader ;
        //new ConfigurationClass(reader, beanName) ;
        SimpleMetadataReaderFactory metadataReaderFactory = new SimpleMetadataReaderFactory();
        String className = MyConfig.class.getName();
        MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(className);
        AnnotationMetadata metadata = metadataReader.getAnnotationMetadata();
        Set<MethodMetadata> annotatedMethods = metadata.getAnnotatedMethods(Bean.class.getName());
        annotatedMethods.forEach(item -> {
            System.out.println(item);
        });
        System.out.println(annotatedMethods.size());
        //this.metadata = metadataReader.getAnnotationMetadata();
       // this.resource = metadataReader.getResource();
        //this.beanName = beanName;
    }
}
