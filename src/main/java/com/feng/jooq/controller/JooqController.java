package com.feng.jooq.controller;

import com.feng.jooq.Persistence.AuthPersistence;
import com.feng.jooq.entity.Author;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("jooq")
public class JooqController {

    private final AuthPersistence authPersistence;

    public JooqController(AuthPersistence authPersistence) {
        this.authPersistence = authPersistence;
    }


    @GetMapping
    public List<Author> getAuthors(){
        return authPersistence.findAllAuthor();
    }

}
