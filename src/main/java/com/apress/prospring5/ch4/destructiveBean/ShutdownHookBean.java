package com.apress.prospring5.ch4.destructiveBean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ShutdownHookBean implements ApplicationContextAware {
    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (ctx instanceof AnnotationConfigApplicationContext) {
            ((AnnotationConfigApplicationContext) ctx).registerShutdownHook();
        }
    }
}
