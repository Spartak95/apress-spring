package com.apress.prospring5.ch4.javaconfig.importannotation;

public class ServiceA implements ServiceInterface {
    @Override
    public void service() {
        System.out.println("Service A");
    }
}
