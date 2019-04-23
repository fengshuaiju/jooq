package com.feng.jooq.jackson.deserialization;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;

@Getter
public class AliasBean {
    @JsonAlias({ "fName", "f_name" })
    private String firstName;
    private String lastName;
}