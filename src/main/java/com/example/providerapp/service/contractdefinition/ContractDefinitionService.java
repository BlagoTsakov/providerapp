package com.example.providerapp.service.contractdefinition;

import com.example.providerapp.component.EntityCreator;
import com.example.providerapp.entity.ContractDefinition;
import com.example.providerapp.exception.EntityNotFoundException;
import com.example.providerapp.model.IdResponseDTO;
import com.example.providerapp.model.contractdefinition.ContractDefinitionDTO;
import com.example.providerapp.repository.contractdefinition.IContractDefinitionRepository;
import com.example.providerapp.service.policy.IPolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.providerapp.mapper.ContractDefinitionMapper.toContractDefinition;

@Service
@RequiredArgsConstructor
public class ContractDefinitionService implements IContractDefinitionService {
    private static final String POLICY = "Policy";

    private final IContractDefinitionRepository contractDefinitionRepository;
    private final IPolicyService policyService;
    private final EntityCreator entityCreator;

    @Override
    public IdResponseDTO createContractDefinition(ContractDefinitionDTO contractDefinitionDTO) {
        requirePolicyExists(contractDefinitionDTO.getAccessPolicyId());
        requirePolicyExists(contractDefinitionDTO.getContractPolicyId());

        ContractDefinition definition = toContractDefinition(contractDefinitionDTO);
        return entityCreator.create(contractDefinitionRepository, definition, "ContractDefinition");
    }

    @Override
    public List<ContractDefinition> findAll() {
        return contractDefinitionRepository.findAll();
    }

    private void requirePolicyExists(String policyId) {
        if (!policyService.exists(policyId)) {
            throw new EntityNotFoundException(POLICY, policyId);
        }
    }
}
