package com.feng.jooq.jackson.serialization;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TypeEnumWithValue {
    TYPE1(1, "Type A"), TYPE2(2, "Type 2");

    private Integer id;
    private String name;

    @JsonValue
    //@JsonValue indicates a single method that the library will use to serialize the entire instance
    public String getName() {
        return name;
    }
}
