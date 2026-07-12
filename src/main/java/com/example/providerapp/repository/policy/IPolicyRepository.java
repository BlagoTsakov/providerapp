package com.example.providerapp.repository.policy;

import com.example.providerapp.entity.Policy;
import com.example.providerapp.repository.SaveResult;

public interface IPolicyRepository {
    SaveResult save(Policy policy);
}