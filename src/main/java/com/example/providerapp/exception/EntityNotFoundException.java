package com.example.providerapp.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entityType, String id) {
        super(entityType + " not found: " + id);
    }
}
