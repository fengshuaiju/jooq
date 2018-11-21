package com.feng.jooq.representation;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class BookDetails {

    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private LocalDate dateOfBirthDay;

    private List<Details> details;

    @Data
    public static class Details {
        private Integer authorId;
        private String title;
        private String contentText;
        private Boolean isSale;
        private LocalDateTime publicationAt;
    }
}
