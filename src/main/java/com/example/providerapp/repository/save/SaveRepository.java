package com.example.providerapp.repository.save;

import com.example.providerapp.entity.IEntity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class SaveRepository<T extends IEntity> implements ISaveRepository<T> {
    protected final Map<String, T> savedData = new ConcurrentHashMap<>();

    @Override
    public SaveResult save(T entity) {
        String entityId = entity.getId();
        IEntity previous = savedData.putIfAbsent(entityId, entity);

        if (previous != null) {
            return new SaveResult.AlreadyExists(entityId);
        }

        return new SaveResult.Saved(entity);
    }
}
