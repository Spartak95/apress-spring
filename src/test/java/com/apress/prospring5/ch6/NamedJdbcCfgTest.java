package com.apress.prospring5.ch6;

import com.apress.prospring5.ch6.config.NamedJdbcConfig;
import com.apress.prospring5.ch6.dao.JdbcSingerDao3;
import com.apress.prospring5.ch6.dao.SingerDao2;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NamedJdbcCfgTest {

    @Test
    void testCfg() {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(NamedJdbcConfig.class);
        SingerDao2 singerDao2 = ctx.getBean(JdbcSingerDao3.class, "singer2Dao");
        assertNotNull(singerDao2);
        String singerName = singerDao2.findNameById(1L);
        assertTrue("John Mayer".equals(singerName));
        ctx.close();
    }
}
