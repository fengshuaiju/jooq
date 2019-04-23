package com.feng.jooq.jackson.deserialization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    private Car car;
    private Date datePurchased;
}
