package com.example.providerapp.repository.base;

import com.example.providerapp.entity.IEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseInMemoryRepository<T extends IEntity> implements IRepository<T> {
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

    @Override
    public List<T> findAll() {
        return new ArrayList<>(savedData.values());
    }
}
