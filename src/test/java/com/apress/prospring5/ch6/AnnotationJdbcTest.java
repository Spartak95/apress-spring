package com.apress.prospring5.ch6;

import com.apress.prospring5.ch6.config.AppConfig;
import com.apress.prospring5.ch6.dao.JdbcSingerDao4;
import com.apress.prospring5.ch6.dao.JdbcSingerDao5;
import com.apress.prospring5.ch6.dao.JdbcSingerDao6;
import com.apress.prospring5.ch6.entities.Album;
import com.apress.prospring5.ch6.entities.Singer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnnotationJdbcTest {
    private GenericApplicationContext ctx;
    private JdbcSingerDao4 jdbcSingerDao4;
    private JdbcSingerDao5 jdbcSingerDao5;
    private JdbcSingerDao6 jdbcSingerDao6;

    @BeforeEach
    void setUp() {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        jdbcSingerDao4 = ctx.getBean(JdbcSingerDao4.class);
        jdbcSingerDao5 = ctx.getBean(JdbcSingerDao5.class);
        jdbcSingerDao6 = ctx.getBean(JdbcSingerDao6.class);
        assertNotNull(jdbcSingerDao4);
        assertNotNull(jdbcSingerDao5);
    }

    @AfterEach
    void tearDown() {
        ctx.close();
    }

    @Test
    void testFindAll() {
        List<Singer> singers = jdbcSingerDao4.findAll();
        assertTrue(singers.size() == 3);
        singers.forEach(singer -> {
            System.out.println(singer);
            if (singer.getAlbums() != null) {
                for (Album album : singer.getAlbums()) {
                    System.out.println("\t-->" + album);
                }
            }
        });
    }

    @Test
    void testFindByFirstName() {
        List<Singer> singers = jdbcSingerDao5.findByFirstName("John");
        assertTrue(singers.size() == 2);
        listSingers(singers);
    }

    @Test
    void testSingerUpdate() {
        Singer singer = new Singer();
        singer.setId(1L);
        singer.setFirstName("John");
        singer.setLastName("Mayer");
        singer.setBirthDate(new Date(new GregorianCalendar(1977, 9, 16).getTime().getTime()));
        jdbcSingerDao6.update(singer);
        List<Singer> singers = jdbcSingerDao6.findAll();
        listSingers(singers);
    }

    private void listSingers(List<Singer> singers) {
        singers.forEach(singer -> {
            System.out.println(singer);
            if (singer.getAlbums() != null) {
                for (Album album : singer.getAlbums()) {
                    System.out.println("\t-->" + album);
                }
            }
        });
    }
}
