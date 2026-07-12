package com.example.providerapp.service.contractdefinition;

import com.example.providerapp.model.IdResponseDTO;
import com.example.providerapp.model.contractdefinition.ContractDefinitionDTO;

public interface IContractDefinitionService {
    IdResponseDTO createContractDefinition(ContractDefinitionDTO contractDefinitionDTO);
}
