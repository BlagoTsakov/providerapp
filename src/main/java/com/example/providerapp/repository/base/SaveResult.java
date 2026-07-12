package com.example.providerapp.repository.base;

import com.example.providerapp.entity.IEntity;

public sealed interface SaveResult {
    record Saved(IEntity entity) implements SaveResult {
    }

    record AlreadyExists(String id) implements SaveResult {
    }
}
