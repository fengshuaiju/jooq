package com.feng.jooq.jackson.serialization;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Person implements Hidable {
    private String name;
    private Address address;
    private boolean hidden;
}