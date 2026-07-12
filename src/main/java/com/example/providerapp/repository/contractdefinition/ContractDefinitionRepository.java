package com.example.providerapp.repository.contractdefinition;

import com.example.providerapp.entity.ContractDefinition;
import com.example.providerapp.repository.save.SaveRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ContractDefinitionRepository extends SaveRepository<ContractDefinition> implements IContractDefinitionRepository {
}
