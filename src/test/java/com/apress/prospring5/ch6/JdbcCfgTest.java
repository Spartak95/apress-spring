package com.apress.prospring5.ch6;

import com.apress.prospring5.ch6.config.EmbeddedJdbcConfig;
import com.apress.prospring5.ch6.dao.SingerDao2;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JdbcCfgTest {

    @Test
    void testH2DB() {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(EmbeddedJdbcConfig.class);
        testDao(ctx.getBean(SingerDao2.class));
        ctx.close();
    }

    private void testDao(SingerDao2 singerDao) {
        assertNotNull(singerDao);
        String singerName = singerDao.findNameById(1L);
        assertTrue("John Mayer".equals(singerName));
    }
}
