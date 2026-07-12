package com.example.providerapp.service.policy;

import com.example.providerapp.component.EntityCreator;
import com.example.providerapp.model.IdResponseDTO;
import com.example.providerapp.model.policy.PolicyDTO;
import com.example.providerapp.repository.policy.IPolicyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.providerapp.mapper.PolicyMapper.toPolicy;

@Service
@RequiredArgsConstructor
public class PolicyService implements IPolicyService {
    private final IPolicyRepository policyRepository;
    private final EntityCreator entityCreator;

    @Override
    public IdResponseDTO createPolicy(PolicyDTO dto) {
        return entityCreator.create(policyRepository, toPolicy(dto), "Policy");
    }
}
