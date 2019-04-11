package com.feng.jooq.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author {

    @EmbeddedId
    private AuthorId id;

    private String name;
    private int age;
    private String sex;
}
