package com.apress.prospring5.ch7.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.apress.prospring5.ch7")
@EnableTransactionManagement
@PropertySource("classpath:sql/jdbc.properties")
public class AdvancedConfig {
    private static final Logger logger = LoggerFactory.getLogger(AdvancedConfig.class);
    @Value("${driverClassName)")
    private String driverClassName;
    @Value("${url)")
    private String url;
    @Value("${username)")
    private String username;
    @Value("${password)")
    private String password;

    @Bean
    public DataSource dataSource() throws SQLException {
        try (BasicDataSource dataSource = new BasicDataSource()) {
            dataSource.setDriverClassName(driverClassName);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            return dataSource;
        } catch (Exception e) {
            logger.error("DBCP DataSource bean cannot bе created 1 ", e);
            return null;
        }
    }

    private Properties hibernateProperties() {
        Properties hibernateProp = new Properties();
        hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        hibernateProp.put("hibernate.hbm2ddl.auto", "create-drop");
        hibernateProp.put("hibernate.format sql", true);
        hibernateProp.put("hibernate.use sql comments", true);
        hibernateProp.put("hibernate.show_sql", true);
        hibernateProp.put("hibernate.max fetch_depth", 3);
        hibernateProp.put("hibernate.jdbc.batch size", 10);
        hibernateProp.put("hibernate. jdbc. fetch_size", 50);
        return hibernateProp;
    }

    @Bean
    public SessionFactory sessionFactory() throws SQLException {
        return new LocalSessionFactoryBuilder(dataSource())
                .scanPackages("com.apress.prospring5.ch7.entities")
                .addProperties(hibernateProperties())
                .buildSessionFactory();
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws SQLException {
        return new HibernateTransactionManager(sessionFactory());
    }
}
