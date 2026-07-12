package com.example.providerapp.model.catalog;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractOfferDTO {
    @JsonProperty("@id")
    private String contractDefinitionId;

    private String accessPolicyId;

    private String contractPolicyId;
}
