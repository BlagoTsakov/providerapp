package com.example.providerapp.repository.save;

import com.example.providerapp.entity.IEntity;

public interface ISaveRepository<T extends IEntity> {
    SaveResult save(T entity);
}
