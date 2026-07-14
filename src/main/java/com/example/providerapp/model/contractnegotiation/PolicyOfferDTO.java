package com.example.providerapp.model.contractnegotiation;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyOfferDTO {
    @JsonProperty("@context")
    private String context;

    @NotBlank
    @JsonProperty("@id")
    private String id;

    @JsonProperty("@type")
    private String type;

    @NotBlank
    private String assigner;

    @NotBlank
    private String target;
}
