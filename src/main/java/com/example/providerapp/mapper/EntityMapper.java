package com.example.providerapp.mapper;

import com.example.providerapp.entity.IEntity;
import com.example.providerapp.model.response.ResponseDTO;

public final class EntityMapper {
    private EntityMapper() {}

    public static ResponseDTO toResponse(IEntity entity) {
        return ResponseDTO.builder()
                .id(entity.getId())
                .createdAt(entity.getCreatedAt().toEpochMilli())
                .build();
    }
}
