package com.apress.prospring5.ch6.config;

import com.apress.prospring5.ch6.dao.JdbcSingerDao4;
import com.apress.prospring5.ch6.dao.JdbcSingerDao5;
import com.apress.prospring5.ch6.dao.JdbcSingerDao6;
import com.apress.prospring5.ch6.dao.JdbcSingerDao7;
import com.apress.prospring5.ch6.dao.JdbcSingerDao8;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Bean
    public DataSource dataSource() {
        try {
            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
            return dbBuilder.setType(EmbeddedDatabaseType.H2)
                    .setName("testDB;MODE=MySQL")
                    .addScripts("classpath:db/h2/schema.sql", "classpath:db/h2/test-data.sql")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Bean
    public JdbcSingerDao4 jdbcSingerDao4() {
        JdbcSingerDao4 jdbcSingerDao4 = new JdbcSingerDao4();
        jdbcSingerDao4.setDataSource(dataSource());
        return jdbcSingerDao4;
    }

    @Bean
    public JdbcSingerDao5 jdbcSingerDao5() {
        JdbcSingerDao5 jdbcSingerDao5 = new JdbcSingerDao5();
        jdbcSingerDao5.setDataSource(dataSource());
        return jdbcSingerDao5;
    }

    @Bean
    public JdbcSingerDao6 jdbcSingerDao6() {
        JdbcSingerDao6 jdbcSingerDao6 = new JdbcSingerDao6();
        jdbcSingerDao6.setDataSource(dataSource());
        return jdbcSingerDao6;
    }

    @Bean
    public JdbcSingerDao7 jdbcSingerDao7() {
        JdbcSingerDao7 jdbcSingerDao7 = new JdbcSingerDao7();
        jdbcSingerDao7.setDataSource(dataSource());
        return jdbcSingerDao7;
    }

    @Bean
    public JdbcSingerDao8 jdbcSingerDao8() {
        JdbcSingerDao8 jdbcSingerDao8 = new JdbcSingerDao8();
        jdbcSingerDao8.setDataSource(dataSource());
        return jdbcSingerDao8;
    }
}
