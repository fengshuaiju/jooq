package com.feng.jpa.controller;

import com.feng.entities.representation.Authors;
import com.feng.entities.representation.BookDetails;
import com.feng.jpa.persistence.JooqPersistence;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jooq")
public class JooqController {

    private final JooqPersistence jooqPersistence;

    public JooqController(JooqPersistence jooqPersistence) {
        this.jooqPersistence = jooqPersistence;
    }

    @GetMapping("/authors")
    public List<Authors> getAuthors() {
        return jooqPersistence.findAllAuthor();
    }

    @GetMapping("/books")
    public List<BookDetails> getBooks(){
        return jooqPersistence.getBooks();
    }
}
