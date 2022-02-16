package com.amankachhal.tapnlearn.tapnlearnbe.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceCategoryResponse {

    @JsonProperty("subCategoryList")
    List<SubCategory> subCategoryList;
    @JsonProperty("resourceDetailsList")
    List<ResourceDetails> resourceDetailsList;
}
