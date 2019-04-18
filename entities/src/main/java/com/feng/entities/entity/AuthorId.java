package com.feng.entities.entity;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
public class AuthorId implements Serializable {
    @Column(name = "author_id", columnDefinition="uuid")
    private UUID value;

    public static AuthorId newId() {
        return new AuthorId(UUID.randomUUID());
    }

    public AuthorId(String value) {
        this.value = UUID.fromString(value);
    }

    public AuthorId(UUID value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString(){
        return this.value.toString();
    }
}
