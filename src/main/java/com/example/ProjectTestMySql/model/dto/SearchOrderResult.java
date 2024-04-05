package com.example.ProjectTestMySql.model.dto;

import com.example.ProjectTestMySql.util.DateTimeDeserializer;
import com.example.ProjectTestMySql.util.DateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.OffsetDateTime;
import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SearchOrderResult {
    String name;
    @JsonDeserialize(using = DateTimeDeserializer.class)
    OffsetDateTime dateTime;
    Long calories;
    Long weight;
}
