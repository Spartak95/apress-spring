package com.apress.prospring5.ch6.dao;

import com.apress.prospring5.ch6.InsertSingerAlbum;
import com.apress.prospring5.ch6.entities.Album;
import com.apress.prospring5.ch6.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcSingerDao8 implements SingerDao2 {
    private DataSource dataSource;
    private InsertSingerAlbum insertSingerAlbum;
    private static final Logger logger = LoggerFactory.getLogger(JdbcSingerDao8.class);

    public void insertWithAlbum(Singer singer) {
        this.insertSingerAlbum = new InsertSingerAlbum(dataSource);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("first_name", singer.getFirstName());
        paramMap.put("last_name", singer.getLastName());
        paramMap.put("birth_date", singer.getBirthDate());

        logger.info("New singer inserted with id: " + singer.getId());
        List<Album> albums = singer.getAlbums();

        if (albums != null) {
            for (Album album : albums) {
                paramMap = new HashMap<>();
                paramMap.put("singer_id", album.getId());
                paramMap.put("title", album.getTitle());
                paramMap.put("release_date", album.getReleaseDate());
                insertSingerAlbum.updateByNamedParam(paramMap);
            }
        }

        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertSingerAlbum.updateByNamedParam(paramMap, keyHolder);
        singer.setId(keyHolder.getKey().longValue());
        insertSingerAlbum.flush();
    }

    public List<Singer> findAllWithAlbums() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        String sql = "SELECT s.id, s.first_name, s.last_name, s.birth_date, a.title, a.release_date FROM singer AS s" +
                " LEFT JOIN album AS a ON s.id = a.singer_id";
        return jdbcTemplate.query(sql, new JdbcSingerDao8.SingerWithAlbumExtractor());
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
    }


    private class SingerWithAlbumExtractor implements ResultSetExtractor<List<Singer>> {
        @Override
        public List<Singer> extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<Long, Singer> map = new HashMap<>();
            Singer singer;
            while (rs.next()) {
                long id = rs.getLong("id");
                singer = map.get(id);
                if (singer == null) {
                    singer = new Singer();
                    singer.setId(id);
                    singer.setFirstName(rs.getString("first_name"));
                    singer.setLastName(rs.getString("last_name"));
                    singer.setBirthDate(rs.getDate("birth_date"));
                    singer.setAlbums(new ArrayList<>());
                    map.put(id, singer);
                }
                long albumId = rs.getLong("album_id");
                if (albumId > 0) {
                    Album album = new Album();
                    album.setId(albumId);
                    album.setSingerId(id);
                    album.setTitle(rs.getString("title"));
                    album.setReleaseDate(rs.getDate("release_date"));
                    singer.getAlbums().add(album);
                }
            }

            return new ArrayList<>(map.values());
        }
    }
}
