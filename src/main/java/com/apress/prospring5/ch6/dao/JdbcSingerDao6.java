package com.apress.prospring5.ch6.dao;

import com.apress.prospring5.ch6.UpdateSinger;
import com.apress.prospring5.ch6.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcSingerDao6 implements SingerDao2 {
    private DataSource dataSource;
    private UpdateSinger updateSinger;
    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcSingerDao6.class);

    public void update(Singer singer) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("first_name", singer.getFirstName());
        paramMap.put("last_name", singer.getLastName());
        paramMap.put("birth_date", singer.getBirthDate());
        paramMap.put("id", singer.getId());
        updateSinger.updateByNamedParam(paramMap);
        LOGGER.info("Existing singer updated with id: " + singer.getId());
    }

    @Override
    public String findNameById(Long id) {
        return null;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.updateSinger = new UpdateSinger(dataSource);
    }

    public List<Singer> findAll() {
        String sql = "select id, first_name, last_name, birth_date from singer";
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate.query(sql, new JdbcSingerDao3.SingerMapper());
    }
}
