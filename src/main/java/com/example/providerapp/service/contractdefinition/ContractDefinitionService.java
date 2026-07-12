package com.example.providerapp.service.contractdefinition;

import com.example.providerapp.component.EntityCreator;
import com.example.providerapp.model.IdResponseDTO;
import com.example.providerapp.model.contractdefinition.ContractDefinitionDTO;
import com.example.providerapp.repository.contractdefinition.IContractDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.providerapp.mapper.ContractDefinitionMapper.toContractDefinition;

@Service
@RequiredArgsConstructor
public class ContractDefinitionService implements IContractDefinitionService {
    private final IContractDefinitionRepository contractDefinitionRepository;
    private final EntityCreator entityCreator;

    @Override
    public IdResponseDTO createContractDefinition(ContractDefinitionDTO contractDefinitionDTO) {
        return entityCreator.create(contractDefinitionRepository, toContractDefinition(contractDefinitionDTO), "ContractDefinition");
    }
}
