package com.example.providerapp.service.policy;

import com.example.providerapp.component.EntityCreator;
import com.example.providerapp.model.response.ResponseDTO;
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
    public ResponseDTO createPolicy(PolicyDTO dto) {
        return entityCreator.create(policyRepository, toPolicy(dto), "Policy");
    }

    @Override
    public boolean exists(String policyId) {
        return policyRepository.exists(policyId);
    }
}
