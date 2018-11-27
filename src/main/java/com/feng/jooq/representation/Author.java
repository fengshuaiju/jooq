package com.feng.jooq.representation;

import com.fasterxml.jackson.annotation.JsonView;
import com.feng.jooq.config.View;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Author {
    private Integer id;
    private String firstName;
    private String lastName;

    @JsonView(View.Boss.class)
    private LocalDate dateOfBirthDay;

    @JsonView(View.Staff.class)
    private String address;
}
