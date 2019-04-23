package com.feng.jooq.jackson.inclusion;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
//We can use @JsonInclude to exclude properties with empty/null/default values
public class MyBean {
    public int id;
    public String name;
}
