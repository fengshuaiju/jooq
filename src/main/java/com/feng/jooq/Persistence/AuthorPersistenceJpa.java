package com.feng.jooq.Persistence;

import com.feng.jooq.entity.Author;
import com.feng.jooq.entity.AuthorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorPersistenceJpa extends JpaRepository<Author, AuthorId> {
}
