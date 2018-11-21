package com.feng.jooq.representation;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Author {
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirthDay;
    private String address;
}
