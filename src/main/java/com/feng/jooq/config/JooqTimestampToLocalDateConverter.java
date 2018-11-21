package com.feng.jooq.config;

import org.jooq.Converter;

import java.sql.Date;
import java.time.LocalDate;

public class JooqTimestampToLocalDateConverter implements Converter<Date, LocalDate> {

    @Override
    public LocalDate from(Date date) {
        return date == null ? null : date.toLocalDate();
    }

    @Override
    public Date to(LocalDate localDate) {
        return Date.valueOf(localDate);
    }

    @Override
    public Class<Date> fromType() {
        return Date.class;
    }

    @Override
    public Class<LocalDate> toType() {
        return LocalDate.class;
    }

}
