package com.example.providerapp.service.asset;

import com.example.providerapp.exception.AssetAlreadyExistsException;
import com.example.providerapp.model.IdResponseDTO;
import com.example.providerapp.model.asset.AssetDTO;
import com.example.providerapp.repository.asset.IAssetRepository;
import com.example.providerapp.repository.SaveResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.providerapp.mapper.AssetMapper.toAsset;
import static com.example.providerapp.mapper.EntityMapper.toIdResponse;

@Service
@RequiredArgsConstructor
public class AssetService implements IAssetService {
    private final IAssetRepository assetRepository;

    @Override
    public IdResponseDTO createAsset(AssetDTO assetDTO) {
        return switch (assetRepository.save(toAsset(assetDTO))) {
            case SaveResult.Saved saved -> toIdResponse(saved.entity());
            case SaveResult.AlreadyExists exists -> throw new AssetAlreadyExistsException(exists.id());
        };
    }
}
