package com.example.providerapp.mapper;

import com.example.providerapp.entity.ContractDefinition;
import com.example.providerapp.model.catalog.CatalogEntryDTO;
import com.example.providerapp.model.catalog.ContractOfferDTO;

import java.util.List;

public final class CatalogMapper {
    private CatalogMapper() {}

    public static CatalogEntryDTO toEntry(String assetId, List<ContractDefinition> definitions) {
        List<ContractOfferDTO> offers = definitions.stream()
                .map(CatalogMapper::toOffer)
                .toList();

        return CatalogEntryDTO.builder()
                .assetId(assetId)
                .offers(offers)
                .build();
    }

    private static ContractOfferDTO toOffer(ContractDefinition definition) {
        return ContractOfferDTO.builder()
                .contractDefinitionId(definition.getId())
                .accessPolicyId(definition.getAccessPolicyId())
                .contractPolicyId(definition.getContractPolicyId())
                .build();
    }
}
