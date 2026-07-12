package com.example.providerapp.exception;

public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String entityType, String entityId) {
        super(entityType + " already exists: " + entityId);
    }
}