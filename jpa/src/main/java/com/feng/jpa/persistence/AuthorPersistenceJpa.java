package com.feng.jpa.persistence;

import com.feng.entities.entity.Author;
import com.feng.entities.entity.AuthorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorPersistenceJpa extends JpaRepository<Author, AuthorId> {
}
