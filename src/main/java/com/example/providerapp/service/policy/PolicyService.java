package com.example.providerapp.service.policy;

import com.example.providerapp.exception.PolicyAlreadyExistsException;
import com.example.providerapp.model.IdResponseDTO;
import com.example.providerapp.model.policy.PolicyDTO;
import com.example.providerapp.repository.save.SaveResult;
import com.example.providerapp.repository.policy.IPolicyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.providerapp.mapper.EntityMapper.toIdResponse;
import static com.example.providerapp.mapper.PolicyMapper.toPolicy;

@Service
@RequiredArgsConstructor
public class PolicyService implements IPolicyService {
    private final IPolicyRepository policyRepository;

    public IdResponseDTO createPolicy(PolicyDTO policyDTO) {
        return switch (policyRepository.save(toPolicy(policyDTO))) {
            case SaveResult.Saved saved -> toIdResponse(saved.entity());
            case SaveResult.AlreadyExists exists -> throw new PolicyAlreadyExistsException(exists.id());
        };
    }
}
