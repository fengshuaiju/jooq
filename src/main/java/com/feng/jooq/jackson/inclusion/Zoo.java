package com.feng.jooq.jackson.inclusion;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Zoo {
    public Animal animal;

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Dog.class, name = "dog"),
            @JsonSubTypes.Type(value = Cat.class, name = "cat")
    })
    @AllArgsConstructor
    public static class Animal {
        public String name;
    }

    @JsonTypeName("dog")
    public static class Dog extends Animal {
        public double barkVolume;

        public Dog(String name) {
            super(name);
        }
    }

    @JsonTypeName("cat")
    public static class Cat extends Animal {
        boolean likesCream;
        public int lives;

        @JsonCreator
        public Cat(String name) {
            super(name);
        }
    }
}