package com.example.providerapp.model.catalog;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogEntryDTO {
    @JsonProperty("@id")
    private String assetId;

    private List<ContractOfferDTO> offers;
}
