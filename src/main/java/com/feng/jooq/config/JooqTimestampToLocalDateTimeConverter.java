package com.feng.jooq.config;

import org.jooq.Converter;

import java.sql.Timestamp;
import java.time.*;

public class JooqTimestampToLocalDateTimeConverter implements Converter<Timestamp, LocalDateTime> {

    @Override
    public LocalDateTime from(Timestamp timestamp) {
        return timestamp == null ? null : timestamp.toLocalDateTime().atZone(ZoneId.of("Asia/Shanghai")).toLocalDateTime();
    }

    @Override
    public Timestamp to(LocalDateTime localDate) {
        return Timestamp.valueOf(localDate);
    }

    @Override
    public Class<Timestamp> fromType() {
        return Timestamp.class;
    }

    @Override
    public Class<LocalDateTime> toType() {
        return LocalDateTime.class;
    }

}
