package com.apress.prospring5.ch4.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Publisher implements ApplicationContextAware {
    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    public void publish(String message) {
        ctx.publishEvent(new MessageEvent(this, message));
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EventConfig.class);
        Publisher pub = ctx.getBean("publisher", Publisher.class);
        pub.publish("I send an SOS to the world...");
        pub.publish("... I hope that someone gets my ...");
        pub.publish("... Message in a bottle");
        ctx.close();
    }
}
