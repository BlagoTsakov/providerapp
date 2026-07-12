package com.example.providerapp.repository.policy;

import com.example.providerapp.entity.Policy;
import com.example.providerapp.repository.save.SaveRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryPolicyRepository extends SaveRepository<Policy> implements IPolicyRepository {
    @Override
    public boolean exists(String id) {
        return savedData.containsKey(id);
    }
}