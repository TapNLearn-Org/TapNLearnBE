package com.amankachhal.tapnlearn.tapnlearnbe.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCategory {

    @JsonProperty("subCategoryId")
    Integer subCategoryId;
    @JsonProperty("categoryId")
    Integer categoryId;
    @JsonProperty("name")
    String name;
}
