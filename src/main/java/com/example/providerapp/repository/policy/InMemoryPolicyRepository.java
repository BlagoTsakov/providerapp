package com.example.providerapp.repository.policy;

import com.example.providerapp.entity.Policy;
import com.example.providerapp.repository.SaveResult;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryPolicyRepository implements IPolicyRepository {
    private final Map<String, Policy> policies = new ConcurrentHashMap<>();

    @Override
    public SaveResult save(Policy policy) {
        String assetId = policy.getId();
        Policy previous = policies.putIfAbsent(assetId, policy);

        if (previous != null) {
            return new SaveResult.AlreadyExists(assetId);
        }

        return new SaveResult.Saved(policy);
    }
}
