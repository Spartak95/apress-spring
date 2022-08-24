package com.apress.prospring5.ch3.annotated;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("abstractLookupBean")
public class AbstractLookupDemoBean implements DemoBean {
    @Override
    @Lookup("singer2")
    public Singer2 getMySinger() {
        return null;
    }

    @Override
    public void doSomething() {
       getMySinger().sing();
    }
}
