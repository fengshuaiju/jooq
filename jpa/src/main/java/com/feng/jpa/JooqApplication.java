package com.feng.jpa;

import com.feng.entities.entity.Author;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = {Author.class})
public class JooqApplication {

    public static void main(String[] args) {
        SpringApplication.run(JooqApplication.class, args);
    }

}
