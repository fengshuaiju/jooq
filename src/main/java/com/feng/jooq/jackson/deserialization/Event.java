package com.feng.jooq.jackson.deserialization;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

public class Event {
    public String name;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public Date eventDate;
}
