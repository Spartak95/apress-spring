package com.apress.prospring5.ch4.factorybean;

import java.security.MessageDigest;
import java.util.Arrays;

import com.apress.prospring5.ch4.factorybean.MessageDigestDemo.MessageDigestConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AccessingFactoryBeans {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MessageDigestConfig.class);
        ctx.getBean("shaDigest", MessageDigest.class);
        MessageDigestFactoryBean factoryBean = ctx.getBean("&shaDigest", MessageDigestFactoryBean.class); // & անհրաժեշտ է
        MessageDigest shaDigest = factoryBean.getObject();
        System.out.println(Arrays.toString(shaDigest.digest("Hello world".getBytes())));
        ctx.close();
    }
}
