package com.feng.jooq.jackson.serialization;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UnwrappedUser {
    public int id;

    @JsonUnwrapped
    public Name name;

    @AllArgsConstructor
    public static class Name {
        public String firstName;
        public String lastName;
    }
}
