package com.apress.prospring5.ch3.annotated;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldSpringAnnotation {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class); // StandardOutMessageRenderer.class
        mr.render();
        // ----------------------------------------
        ApplicationContext ctx2 = new AnnotationConfigApplicationContext(HelloWorldConfiguration2.class);
        MessageRenderer mr2 = ctx2.getBean("renderer", MessageRenderer.class);
        mr2.render();
    }
}
