package com.apress.prospring5.ch6;

import com.apress.prospring5.ch6.dao.PlainSingerDao;
import com.apress.prospring5.ch6.dao.SingerDao;
import com.apress.prospring5.ch6.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class PlainJdbcDemo {
    private static SingerDao SINGER_DAO = new PlainSingerDao();
    private static final Logger LOGGER = LoggerFactory.getLogger(PlainJdbcDemo.class);

    public static void main(String[] args) {
        LOGGER.info("Linting initial singer data:");
        listAllSingers();
        LOGGER.info("--------");
        LOGGER.info("insert a new singer");

        Singer singer = new Singer();
        singer.setFirstName("Ed");
        singer.setLastName("Sheeran");
        singer.setBirthDate(new Date(new GregorianCalendar().getTime().getTime()));
        SINGER_DAO.insert(singer);

        LOGGER.info("Listing singer data after new singer created");

        listAllSingers();

        LOGGER.info("----------");
        LOGGER.info("Deleting the previous created singer");
        SINGER_DAO.delete(singer.getId());
        LOGGER.info("Listing singer data after new singer deleted:");

        listAllSingers();
    }

    private static void listAllSingers() {
        List<Singer> singers = SINGER_DAO.findAll();
        for (Singer singer : singers) {
            LOGGER.info(singer.toString());
        }
    }
}
