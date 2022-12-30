package com.apress.prospring5.ch8;

import com.apress.prospring5.ch8.config.EnversConfig;
import com.apress.prospring5.ch8.entities.SingerAudit;
import com.apress.prospring5.ch8.services.SingerAuditService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class SpringEnversJPADemo {
    public static void main (String ... args) {
        GenericApplicationContext ctx =
                new AnnotationConfigApplicationContext(EnversConfig.class);
        SingerAuditService singerAuditService = ctx.getBean(SingerAuditService.class);
        System.out.println("Add new singer");
        SingerAudit singer = new SingerAudit();
        singer.setFirstName("BB");
        singer.setLastName("King");
        singer.setBirthDate(new Date((new GregorianCalendar(1940, 8, 16)).getTime() .getTime() )) ;
        singerAuditService.save(singer);
        listSingers(singerAuditService.findAll() );
        System.out.println("Update singer");
        singer.setFirstName("Riley В.");
        singerAuditService.save(singer);
        listSingers(singerAuditService.findAll());
        SingerAudit oldSinger = singerAuditService.findAuditByRevision(4L, 1);
        System.out.println("");
        System.out.println("Old Singer with id 1 and rev 1:" + oldSinger);
        System.out.println("");
        oldSinger = singerAuditService.findAuditByRevision(4L, 2);
        System.out.println("");
        System.out.println("Old Singer with id 1 and rev 2:" + oldSinger);
        System.out.println("");
        ctx.close();
    }

    private static void listSingers(List<SingerAudit> singers) {
        System.out.println("");
        System.out.println("Listing singers:");

        for (SingerAudit singer: singers) {
            System.out.println(singer);
            System.out.println();
        }
    }
}
