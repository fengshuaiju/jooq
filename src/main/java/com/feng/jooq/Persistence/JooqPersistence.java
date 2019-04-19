package com.feng.jooq.Persistence;

import com.feng.jooq.entity.Author;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JooqPersistence {

    private final AuthorPersistenceJpa authorPersistenceJpa;

    public JooqPersistence(AuthorPersistenceJpa authorPersistenceJpa) {
        this.authorPersistenceJpa = authorPersistenceJpa;
    }


    public List<Author> findAllAuthor() {
        return authorPersistenceJpa.findAll();
    }
}
