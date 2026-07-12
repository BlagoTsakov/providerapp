package com.example.providerapp.mapper;

import com.example.providerapp.entity.ContractDefinition;
import com.example.providerapp.model.contractdefinition.ContractDefinitionDTO;

import java.time.Instant;

final public class ContractDefinitionMapper {
    private ContractDefinitionMapper() {
    }

    public static ContractDefinition toContractDefinition(ContractDefinitionDTO contractDefinitionDTO) {
        return ContractDefinition.builder()
                .id(contractDefinitionDTO.getId())
                .contractPolicyId(contractDefinitionDTO.getContractPolicyId())
                .accessPolicyId(contractDefinitionDTO.getAccessPolicyId())
                .assetsSelector(contractDefinitionDTO.getAssetsSelector())
                .createdAt(Instant.now())
                .build();
    }
}
