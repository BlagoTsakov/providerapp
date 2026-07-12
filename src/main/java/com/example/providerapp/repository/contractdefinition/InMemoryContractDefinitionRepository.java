package com.example.providerapp.repository.contractdefinition;

import com.example.providerapp.entity.ContractDefinition;
import com.example.providerapp.repository.base.BaseInMemoryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryContractDefinitionRepository extends BaseInMemoryRepository<ContractDefinition> implements IContractDefinitionRepository {
}
