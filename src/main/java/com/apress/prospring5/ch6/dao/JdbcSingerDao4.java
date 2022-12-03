package com.apress.prospring5.ch6.dao;

import com.apress.prospring5.ch6.SelectAllSingers;
import com.apress.prospring5.ch6.entities.Singer;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Repository("singerDao4")
public class JdbcSingerDao4 implements SingerDao2 {
    private DataSource dataSource;
    private SelectAllSingers selectAllSingers;

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllSingers = new SelectAllSingers(dataSource);
    }

    public List<Singer> findAll() {
        return selectAllSingers.execute();
    }

    @Override
    public String findNameById(Long id) {
        return null;
    }
}
