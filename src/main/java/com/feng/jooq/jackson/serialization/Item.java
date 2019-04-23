package com.feng.jooq.jackson.serialization;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Item {
    @JsonView(Views.Public.class)
    public int id;

    @JsonView(Views.Public.class)
    public String itemName;

    @JsonView(Views.Internal.class)
    public String ownerName;
}
