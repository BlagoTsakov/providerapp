package com.example.providerapp.exception;

public class PolicyAlreadyExistsException extends RuntimeException {
    public PolicyAlreadyExistsException(String policyId) {
        super("Policy already exists: " + policyId);
    }
}
