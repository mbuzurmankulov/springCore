package com.epam.spring.core.domain;

import lombok.Data;
import lombok.ToString;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Random;

@Data
@ToString
public class Event {
    private Integer id;
    private String msg;
    private LocalDate date;
    private DateFormat df;

    public Event(Integer id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public Event(LocalDate date, DateFormat df){
        Random random = new Random(100);
        id = random.nextInt();
        this.date = date;
        this.df = df;
    }
}
