package com.example.providerapp.service.contractdefinition;

import com.example.providerapp.entity.ContractDefinition;
import com.example.providerapp.model.response.ResponseDTO;
import com.example.providerapp.model.contractdefinition.ContractDefinitionDTO;

import java.util.List;

public interface IContractDefinitionService {
    ResponseDTO createContractDefinition(ContractDefinitionDTO contractDefinitionDTO);
    List<ContractDefinition> findAll();
    boolean exists(String id);
}
