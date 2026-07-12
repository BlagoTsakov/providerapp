package com.example.providerapp.component;

import com.example.providerapp.entity.IEntity;
import com.example.providerapp.exception.EntityAlreadyExistsException;
import com.example.providerapp.model.IdResponseDTO;
import com.example.providerapp.repository.base.IRepository;
import com.example.providerapp.repository.base.SaveResult;
import org.springframework.stereotype.Component;

import static com.example.providerapp.mapper.EntityMapper.toIdResponse;

@Component
public class EntityCreator {
    public <E extends IEntity> IdResponseDTO create(
            IRepository<E> repository,
            E entity,
            String entityType
    ) {
        return switch (repository.save(entity)) {
            case SaveResult.Saved saved -> toIdResponse(saved.entity());
            case SaveResult.AlreadyExists exists -> throw new EntityAlreadyExistsException(entityType, exists.id());
        };
    }
}
