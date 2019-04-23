package com.feng.jooq.jackson.serialization;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class Event {

    public String name;

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date eventDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    public Date date;
}
