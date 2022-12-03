package com.apress.prospring5.ch6.dao;

import com.apress.prospring5.ch6.InsertSinger;
import com.apress.prospring5.ch6.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcSingerDao7 implements SingerDao2 {
    private DataSource dataSource;
    private InsertSinger insertSinger;
    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcSingerDao7.class);

    public void insert(Singer singer) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("first_name", singer.getFirstName());
        paramMap.put("last_name", singer.getLastName());
        paramMap.put("birth_date", singer.getBirthDate());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertSinger.updateByNamedParam(paramMap, keyHolder);
        singer.setId(keyHolder.getKey().longValue());
        LOGGER.info("New singer inserted with id: " + singer.getId());
    }

    @Override
    public String findNameById(Long id) {
        return null;
    }

    public List<Singer> findAll() {
        String sql = "select id, first_name, last_name, birth_date from singer";
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate.query(sql, new JdbcSingerDao3.SingerMapper());
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.insertSinger = new InsertSinger(dataSource);
    }
}
