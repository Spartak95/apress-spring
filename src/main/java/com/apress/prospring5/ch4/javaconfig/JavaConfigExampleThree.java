package com.apress.prospring5.ch4.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigExampleThree {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigThree.class);
        MessageRenderer renderer = ctx.getBean("messageRenderer", MessageRenderer.class);
        renderer.render();
    }
}
