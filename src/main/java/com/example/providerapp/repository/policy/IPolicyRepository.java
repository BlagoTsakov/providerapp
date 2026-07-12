package com.example.providerapp.repository.policy;

import com.example.providerapp.entity.Policy;
import com.example.providerapp.repository.base.IRepository;

public interface IPolicyRepository extends IRepository<Policy> {
    boolean exists(String id);
}