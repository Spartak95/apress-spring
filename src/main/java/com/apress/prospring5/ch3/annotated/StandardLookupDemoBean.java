package com.apress.prospring5.ch3.annotated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("standardLookupBean")
public class StandardLookupDemoBean implements DemoBean {
    private Singer2 mySinger;

    @Override
    public Singer2 getMySinger() {
        return this.mySinger;
    }

    @Autowired
    @Qualifier("singer2")
    public void setMySinger(Singer2 mySinger) {
        this.mySinger = mySinger;
    }

    @Override
    public void doSomething() {
        mySinger.sing();
    }
}
