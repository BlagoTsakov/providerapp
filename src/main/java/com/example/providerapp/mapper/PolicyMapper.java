package com.example.providerapp.mapper;

import com.example.providerapp.entity.Policy;
import com.example.providerapp.model.policy.PolicyDTO;

import java.time.Instant;

public final class PolicyMapper {
    private PolicyMapper() {
    }

    public static Policy toPolicy(PolicyDTO policyDTO) {
        return Policy.builder()
                .id(policyDTO.getId())
                .type(policyDTO.getPolicySettings().getType())
                .createdAt(Instant.now())
                .build();
    }
}
