package com.example.providerapp.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entityType, String entityId) {
        super(entityType + " with ID " + entityId + " not found");
    }
}
