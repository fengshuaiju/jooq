package com.feng.jooq.jackson.deserialization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
//转换时未知字段不报错
@JsonIgnoreProperties(ignoreUnknown = true)
public class Car {
    private String color;
    private String type;
}
