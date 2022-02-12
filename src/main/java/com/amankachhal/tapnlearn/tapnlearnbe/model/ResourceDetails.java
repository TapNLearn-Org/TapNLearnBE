package com.amankachhal.tapnlearn.tapnlearnbe.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDetails {
    @JsonProperty("name")
    String name;
    @JsonProperty("image")
    Uri imagePath;
}
