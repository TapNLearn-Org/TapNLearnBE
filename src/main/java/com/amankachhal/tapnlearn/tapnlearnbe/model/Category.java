package com.amankachhal.tapnlearn.tapnlearnbe.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @JsonProperty("id")
    Integer id;
    @JsonProperty("name")
    String name;
}
