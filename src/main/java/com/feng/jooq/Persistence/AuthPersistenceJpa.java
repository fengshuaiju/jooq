package com.feng.jooq.Persistence;

import com.feng.jooq.entity.Author;
import com.feng.jooq.entity.AuthorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthPersistenceJpa extends JpaRepository<Author, AuthorId> {
}
