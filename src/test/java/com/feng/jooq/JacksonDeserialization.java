package com.feng.jooq;

import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feng.jooq.jackson.deserialization.AliasBean;
import com.feng.jooq.jackson.deserialization.BeanWithCreator;
import com.feng.jooq.jackson.deserialization.BeanWithInject;
import com.feng.jooq.jackson.deserialization.Event;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

@Slf4j
public class JacksonDeserialization {

    @Test
    public void whenDeserializingUsingJsonCreator_thenCorrect() throws IOException {
        String json = "{\"id\":1,\"theName\":\"My bean\"}";

        BeanWithCreator bean = new ObjectMapper()
                .readerFor(BeanWithCreator.class)
                .readValue(json);
        assertEquals("My bean", bean.name);
    }

    @Test
    public void whenDeserializingUsingJsonInject_thenCorrect() throws IOException {
        String json = "{\"name\":\"My bean\"}";

        InjectableValues inject = new InjectableValues.Std().addValue(int.class, 1);
        BeanWithInject bean = new ObjectMapper().reader(inject)
                .forType(BeanWithInject.class)
                .readValue(json);

        assertEquals("My bean", bean.name);
        assertEquals(1, bean.id);
    }


    @Test
    public void whenDeserializingUsingJsonDeserialize_thenCorrect() throws IOException {

        String json = "{\n" +
                "  \"name\": \"party\",\n" +
                "  \"eventDate\": \"20-12-2014 02:30:00\"\n" +
                "}";

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        Event event = new ObjectMapper()
                .readerFor(Event.class)
                .readValue(json);

        assertEquals("20-12-2014 02:30:00", df.format(event.eventDate));
    }


    @Test
    public void whenDeserializingUsingJsonAlias_thenCorrect() throws IOException {
        String json = "{\"fName\": \"John\", \"lastName\": \"Green\"}";
        AliasBean aliasBean = new ObjectMapper().readerFor(AliasBean.class).readValue(json);
        assertEquals("John", aliasBean.getFirstName());
    }

}
