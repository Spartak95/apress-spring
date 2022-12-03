package com.apress.prospring5.ch6;

import com.apress.prospring5.ch6.config.NamedJdbcConfig;
import com.apress.prospring5.ch6.dao.JdbcSingerDao3;
import com.apress.prospring5.ch6.entities.Album;
import com.apress.prospring5.ch6.entities.Singer;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RowMapperTest {

    @Test
    void testRowMapper() {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(NamedJdbcConfig.class);
        JdbcSingerDao3 jdbcSingerDao3 = ctx.getBean(JdbcSingerDao3.class);
        assertNotNull(jdbcSingerDao3);
        List<Singer> singers = jdbcSingerDao3.findAll();
        assertTrue(singers.size() == 3);

        singers.forEach(singer -> {
            System.out.println(singer);
            if (singer.getAlbums() != null) {
                for (Album album : singer.getAlbums()) {
                    System.out.println("---" + album);
                }
            }
        });
        ctx.close();
    }
}
