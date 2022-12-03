package com.apress.prospring5.ch6.dao;

import com.apress.prospring5.ch6.SelectSingerByFirstName;
import com.apress.prospring5.ch6.entities.Singer;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcSingerDao5 implements SingerDao2 {
    private DataSource dataSource;
    private SelectSingerByFirstName selectSingerByFirstName;

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectSingerByFirstName = new SelectSingerByFirstName(dataSource);
    }

    public List<Singer> findAll() {
        return selectSingerByFirstName.execute();
    }

    @Override
    public String findNameById(Long id) {
        return null;
    }

    public List<Singer> findByFirstName(String firstName) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("first_name", firstName);
        return selectSingerByFirstName.executeByNamedParam(paramMap);
    }
}
