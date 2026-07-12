package com.example.providerapp.mapper;

import com.example.providerapp.entity.IEntity;
import com.example.providerapp.model.IdResponseDTO;

public final class EntityMapper {
    private EntityMapper() {}

    public static IdResponseDTO toIdResponse(IEntity entity) {
        return IdResponseDTO.builder()
                .id(entity.getId())
                .createdAt(entity.getCreatedAt().toEpochMilli())
                .build();
    }
}
