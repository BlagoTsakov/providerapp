package com.example.providerapp.repository.base;

import com.example.providerapp.entity.IEntity;

import java.util.List;
import java.util.Optional;

public interface IRepository<T extends IEntity> {
    SaveResult save(T entity);
    List<T> findAll();
    Optional<T> findById(String id);
    void update(T entity);
}
