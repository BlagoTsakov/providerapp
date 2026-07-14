package com.example.providerapp.model.contractnegotiation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ContractNegotiationDTO {
    @JsonProperty("@type")
    private final String type = "ContractNegotiation";

    @JsonProperty("@id")
    private String id;

    private String state;

    private String counterPartyId;

    private String agreementId;

    private long createdAt;
}
