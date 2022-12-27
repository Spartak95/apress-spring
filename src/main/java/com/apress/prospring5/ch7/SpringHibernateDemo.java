package com.apress.prospring5.ch7;

import java.util.List;

import com.apress.prospring5.ch7.config.AppConfig;
import com.apress.prospring5.ch7.dao.SingerDao;
import com.apress.prospring5.ch7.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class SpringHibernateDemo {
    private static final Logger logger = LoggerFactory.getLogger(SpringHibernateDemo.class);

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SingerDao singerDao = ctx.getBean(SingerDao.class);
        listSingers(singerDao.findAll());

        ctx.close();
    }

    private static void listSingers(List<Singer> singers) {
        logger.info(" ---- Listing singers:");

        for (Singer singer : singers) {
            logger.info(singer.toString());
        }
    }
}
