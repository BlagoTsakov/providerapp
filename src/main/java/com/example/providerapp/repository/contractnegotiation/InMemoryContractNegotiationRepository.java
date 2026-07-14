package com.example.providerapp.repository.contractnegotiation;

import com.example.providerapp.entity.ContractNegotiation;
import com.example.providerapp.repository.base.BaseInMemoryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryContractNegotiationRepository extends BaseInMemoryRepository<ContractNegotiation> implements IContractNegotiationRepository {
}
