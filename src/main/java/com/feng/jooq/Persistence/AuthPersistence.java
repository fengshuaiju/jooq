package com.feng.jooq.Persistence;

import com.feng.jooq.entity.Author;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthPersistence {

    private final AuthPersistenceJpa authPersistenceJpa;

    public AuthPersistence(AuthPersistenceJpa authPersistenceJpa) {
        this.authPersistenceJpa = authPersistenceJpa;
    }


    public List<Author> findAllAuthor() {
        return authPersistenceJpa.findAll();
    }
}
