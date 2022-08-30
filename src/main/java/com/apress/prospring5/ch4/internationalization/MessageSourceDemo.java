package com.apress.prospring5.ch4.internationalization;

import java.util.Locale;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MessageSourceDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MessageSourceConfig.class);

        Locale english = Locale.ENGLISH;
        Locale german = new Locale("de", "DE");

        System.out.println(ctx.getMessage("msg", null, english));
        System.out.println(ctx.getMessage("msg", null, german));
        System.out.println(ctx.getMessage("nameMsg", new Object[]{"John", "Mayer"}, english));
        System.out.println(ctx.getMessage("nameMsg", new Object[]{"John", "Mayer"}, german));

        ctx.close();
    }
}
