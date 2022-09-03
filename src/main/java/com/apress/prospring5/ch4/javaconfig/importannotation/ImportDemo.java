package com.apress.prospring5.ch4.javaconfig.importannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImportDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigA.class);
        ServiceA serviceA = ctx.getBean("serviceA", ServiceA.class);
        serviceA.service();
    }
}
