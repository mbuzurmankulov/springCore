package com.epam.spring.core.loggers;

import com.epam.spring.core.domain.Event;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBLogger implements EventLogger{

    private JdbcTemplate jdbcTemplate;

    public DBLogger(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void logEvent(Event event) {
        jdbcTemplate.update("insert into public.t_event(id,msg) values (?,?)", event.getId(), event.getMsg());
    }
}
