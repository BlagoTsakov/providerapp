package com.example.providerapp.service.contractdefinition;

import com.example.providerapp.entity.ContractDefinition;
import com.example.providerapp.model.IdResponseDTO;
import com.example.providerapp.model.contractdefinition.ContractDefinitionDTO;

import java.util.List;

public interface IContractDefinitionService {
    IdResponseDTO createContractDefinition(ContractDefinitionDTO contractDefinitionDTO);
    List<ContractDefinition> findAll();
}
