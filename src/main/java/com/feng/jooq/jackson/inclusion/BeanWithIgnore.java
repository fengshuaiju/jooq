package com.feng.jooq.jackson.inclusion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;

@JsonIgnoreProperties({ "id" })
@AllArgsConstructor
public class BeanWithIgnore {
    public int id;
    public String name;
    private String sex;
}