package com.apress.prospring5.ch3.annotated;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotatedBeanNaming {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanNameConfig.class);
        Map<String, Singer3> beans = ctx.getBeansOfType(Singer3.class);
        beans.entrySet().stream().forEach(b -> System.out.println("id: " + b.getKey()));
    }
}
