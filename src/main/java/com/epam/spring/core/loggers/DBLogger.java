package com.epam.spring.core.loggers;

import com.epam.spring.core.domain.Event;
import org.springframework.jdbc.core.JdbcTemplate;

public class DBLogger implements EventLogger{

    private JdbcTemplate jdbcTemplate;

    public DBLogger(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void logEvent(Event event) {

    }
}
