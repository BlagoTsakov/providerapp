package com.example.providerapp.repository.policy;

import com.example.providerapp.entity.Policy;
import com.example.providerapp.repository.base.BaseInMemoryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryPolicyRepository extends BaseInMemoryRepository<Policy> implements IPolicyRepository {
    @Override
    public boolean exists(String id) {
        return savedData.containsKey(id);
    }
}