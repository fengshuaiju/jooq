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
public class AuthorId implements Serializable {
    @JsonValue
    @Column(name = "author_id", columnDefinition="uuid")
    private UUID value;

    public static AuthorId newId() {
        return new AuthorId(UUID.randomUUID());
    }

    public AuthorId(String value) {
        this.value = UUID.fromString(value);
    }

}
