package com.feng.jooq.entity;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BookId implements Serializable {
    @JsonValue
    @Column(name = "book_id", columnDefinition="uuid")
    private UUID value;

    public static BookId newId() {
        return new BookId(UUID.randomUUID());
    }

    public BookId(String value) {
        this.value = UUID.fromString(value);
    }

}
