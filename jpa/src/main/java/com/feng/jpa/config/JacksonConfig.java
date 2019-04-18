package com.feng.jpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDateTime;

@SpringBootConfiguration
public class JacksonConfig {

    private final MyLocalDateTimeDeserializer myLocalDateTimeDeserializer;

    @Autowired
    public JacksonConfig(MyLocalDateTimeDeserializer myLocalDateTimeDeserializer) {
        this.myLocalDateTimeDeserializer = myLocalDateTimeDeserializer;
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer addLocalDateTimeDeserialization() {
        return new Jackson2ObjectMapperBuilderCustomizer() {
            @Override
            public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
                jacksonObjectMapperBuilder.serializerByType(LocalDateTime.class, myLocalDateTimeDeserializer);
            }
        };
    }
}
