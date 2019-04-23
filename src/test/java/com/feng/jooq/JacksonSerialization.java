package com.feng.jooq;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.*;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.feng.jooq.jackson.custom.HidableSerializer;
import com.feng.jooq.jackson.serialization.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

@Slf4j
public class JacksonSerialization {

    @Test
    public void whenSerializingUsingJsonAnyGetter_thenCorrect() throws JsonProcessingException {
        // @JsonPropertyOrder
        MyBean bean = new MyBean(1, "My bean");

        String result = new ObjectMapper().writeValueAsString(bean);
        log.info(result);

        assertThat(result, containsString("My bean"));
        assertThat(result, containsString("1"));


        //@JsonRootName
        MyBean myBean = new MyBean(2, "My bean2");
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String myresult = mapper.writeValueAsString(myBean);
        log.info(myresult);

        assertThat(myresult, containsString("myBean"));
    }


    @Test
    public void whenSerializingUsingJsonValue_thenCorrect() throws IOException {
        String enumAsString = new ObjectMapper().writeValueAsString(TypeEnumWithValue.TYPE1);
        assertThat(enumAsString, is("\"Type A\""));
    }


    @Test
    public void whenSerializingUsingJsonSerialize_thenCorrect() throws JsonProcessingException, ParseException {

        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");

        String toParse = "2014年12月20日 02时31分08秒";
        Date date = df.parse(toParse);
        Event event = new Event("party", date, date);

        String result = new ObjectMapper().writeValueAsString(event);
        log.info(result);
        assertThat(result, containsString(toParse));
    }


    @Test
    public void whenSerializingUsingJsonUnwrapped_thenCorrect() throws JsonProcessingException {
        UnwrappedUser.Name name = new UnwrappedUser.Name("John", "Doe");
        UnwrappedUser user = new UnwrappedUser(1, name);

        String result = new ObjectMapper().writeValueAsString(user);

        log.info(result);

        assertThat(result, containsString("John"));
        assertThat(result, not(containsString("name")));
    }


    @Test
    public void whenSerializingUsingJsonView_thenCorrect() throws JsonProcessingException {
        Item item = new Item(2, "book", "John");

        String result = new ObjectMapper().writerWithView(Views.Public.class).writeValueAsString(item);

        assertThat(result, containsString("book"));
        assertThat(result, containsString("2"));
        assertThat(result, not(containsString("John")));
    }

    @Test
    public void filter() throws JsonProcessingException {

        PropertyFilter theFilter = new SimpleBeanPropertyFilter() {
            @Override
            public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer) throws Exception {
                writer.serializeAsField(pojo, jgen, provider);


                log.info("filter logic ==========================");

//                if (include(writer)) {
//                    if (!writer.getName().equals("intValue")) {
//                        writer.serializeAsField(pojo, jgen, provider);
//                        return;
//                    }
//                    int intValue = ((MyDtoWithFilter) pojo).getIntValue();
//                    if (intValue >= 0) {
//                        writer.serializeAsField(pojo, jgen, provider);
//                    }
//                } else if (!jgen.canOmitFields()) { // since 2.3
//                    writer.serializeAsOmittedField(pojo, jgen, provider);
//                }

            }

            @Override
            protected boolean include(BeanPropertyWriter writer) {
                return true;
            }

            @Override
            protected boolean include(PropertyWriter writer) {
                return true;
            }
        };


        FilterProvider filters = new SimpleFilterProvider().addFilter("myFilter", theFilter);
        MyDto dtoObject = new MyDto();
        dtoObject.setIntValue(-1);

        ObjectMapper mapper = new ObjectMapper();
        String dtoAsString = mapper.writer(filters).writeValueAsString(dtoObject);
    }


    @Test
    public void beanSerializerModifier() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.registerModule(new SimpleModule() {
            @Override
            public void setupModule(SetupContext context) {
                super.setupModule(context);
                context.addBeanSerializerModifier(new BeanSerializerModifier() {
                    @Override
                    public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription desc, JsonSerializer<?> serializer) {
                        if (Hidable.class.isAssignableFrom(desc.getBeanClass())) {
                            return new HidableSerializer((JsonSerializer<Object>) serializer);
                        }
                        return serializer;
                    }
                });
            }
        });


        Address ad1 = new Address("tokyo", "jp", true);
        Address ad2 = new Address("london", "uk", false);
        Address ad3 = new Address("ny", "usa", false);
        Person p1 = new Person("john", ad1, false);
        Person p2 = new Person("tom", ad2, true);
        Person p3 = new Person("adam", ad3, false);

        log.info(mapper.writeValueAsString(Arrays.asList(p1, p2, p3)));
    }


}
