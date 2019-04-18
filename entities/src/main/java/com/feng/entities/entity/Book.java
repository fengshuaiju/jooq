package com.feng.entities.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {

    @EmbeddedId
    private BookId id;

    private String name;

    @Column(name = "publish_day")
    private LocalDate publishDay;

    @Column(name = "create_at")
    private Instant createAt;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "book_chapter", joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"))
    private Set<Chapter> chapters;


    @Embeddable
    @NoArgsConstructor
    private class Chapter {
        private String name;
        private String summary;
        private int index;
    }
}
