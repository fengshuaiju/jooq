package com.feng.jooq.jackson.serialization;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Address implements Hidable {
    private String city;
    private String country;
    private boolean hidden;
}