package com.apress.prospring5.ch7.dao;

import java.util.List;

import com.apress.prospring5.ch7.entities.Singer;

public interface SingerDao {
    List<Singer> findAll();
    List<Singer> findAllWithAlbum();
    Singer findById(Long id);
    Singer save(Singer singer);
    void delete(Singer singer);
}
