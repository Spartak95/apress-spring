package com.apress.prospring5.ch6.config;

import com.apress.prospring5.ch6.dao.JdbcSingerDao2;
import com.apress.prospring5.ch6.dao.JdbcSingerDao3;
import com.apress.prospring5.ch6.dao.SingerDao2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class NamedJdbcConfig {

    @Bean
    public DataSource dataSource() {
        try {
            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
            return dbBuilder.setType(EmbeddedDatabaseType.H2)
                    .setName("MUSICDB;MODE=MySQL")
                    .addScript("classpath:db/h2/schema.sql")
                    .addScript("classpath:db/h2/test-data.sql")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Bean("singer2Dao")
    public SingerDao2 singer2Dao() {
        JdbcSingerDao2 dao = new JdbcSingerDao2();
        dao.setNamedParameterJdbcTemplate(namedParameterJdbcTemplate());
        return dao;
    }

    @Bean("singer2Dao3")
    public SingerDao2 singer2Dao3() {
        JdbcSingerDao3 dao = new JdbcSingerDao3();
        dao.setNamedParameterJdbcTemplate(namedParameterJdbcTemplate());
        return dao;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }
}
