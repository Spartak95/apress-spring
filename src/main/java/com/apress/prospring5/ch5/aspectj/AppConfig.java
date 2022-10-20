package com.apress.prospring5.ch5.aspectj;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.apress.prospring5.ch5.aspectj"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
    // proxyTargetClass = true նշանակում է, որ Java Dynamic Proxy փոխարեն օգտագործելու ենք CGLIB
}
