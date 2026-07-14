package com.example.providerapp.service.policy;

import com.example.providerapp.model.response.ResponseDTO;
import com.example.providerapp.model.policy.PolicyDTO;

public interface IPolicyService {
    ResponseDTO createPolicy(PolicyDTO policyDTO);
    boolean exists(String policyId);
}
