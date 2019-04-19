package com.feng.jooq.controller;

import com.feng.jooq.Persistence.JooqPersistence;
import com.feng.jooq.entity.Author;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("jooq")
public class JooqController {

    private final JooqPersistence jooqPersistence;

    public JooqController(JooqPersistence jooqPersistence) {
        this.jooqPersistence = jooqPersistence;
    }


    @GetMapping
    public List<Author> getAuthors(){
        return jooqPersistence.findAllAuthor();
    }

}
