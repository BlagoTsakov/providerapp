package com.example.providerapp.service.policy;

import com.example.providerapp.model.IdResponseDTO;
import com.example.providerapp.model.policy.PolicyDTO;

public interface IPolicyService {
    IdResponseDTO createPolicy(PolicyDTO policyDTO);
}
