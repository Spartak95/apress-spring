package com.apress.prospring5.ch5;

import com.apress.prospring5.ch5.introduction.Contact;
import com.apress.prospring5.ch5.introduction.IsModified;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IntroductionConfigDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Contact bean = (Contact) ctx.getBean("bean");
        IsModified proxyInterface = (IsModified) bean;

        System.out.println("Is Contact?: " + (bean instanceof Contact));
        System.out.println("Is Modified?: " + (bean instanceof IsModified));
        System.out.println("Has been modified?: " + proxyInterface.isModified());

        bean.setName("John Mayer");

        System.out.println("Has been modified?: " + proxyInterface.isModified());

        bean.setName("Eric Clapton");

        System.out.println("Has been modified?: " + proxyInterface.isModified());
    }
}
