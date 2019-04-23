package com.feng.jooq.jackson.serialization;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;

@AllArgsConstructor
//We can use the @JsonPropertyOrder annotation to specify the order of properties on serialization
@JsonPropertyOrder({"name", "id"})

@JsonRootName(value = "myBean")
public class MyBean {
    public int id;
    public String name;
}
