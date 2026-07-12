package com.example.providerapp.repository.base;

import com.example.providerapp.entity.IEntity;

import java.util.List;

public interface IRepository<T extends IEntity> {
    SaveResult save(T entity);
    List<T> findAll();
}
