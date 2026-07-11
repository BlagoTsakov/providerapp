package com.example.providerapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class IdResponseDTO {
    @JsonProperty("@type")
    private final String type = "IdResponse";

    @JsonProperty("@id")
    private String id;

    private long createdAt;
}