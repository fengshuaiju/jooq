package com.feng.jooq.jackson.deserialization;

import com.fasterxml.jackson.annotation.JacksonInject;

public class BeanWithInject {
    @JacksonInject
    public int id;

    public String name;
}
