package com.example.providerapp.service.asset;

import com.example.providerapp.component.EntityCreator;
import com.example.providerapp.entity.Asset;
import com.example.providerapp.model.IdResponseDTO;
import com.example.providerapp.model.asset.AssetDTO;
import com.example.providerapp.repository.asset.IAssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.providerapp.mapper.AssetMapper.toAsset;

@Service
@RequiredArgsConstructor
public class AssetService implements IAssetService {
    private final IAssetRepository assetRepository;
    private final EntityCreator entityCreator;

    @Override
    public IdResponseDTO createAsset(AssetDTO dto) {
        return entityCreator.create(assetRepository, toAsset(dto), "Asset");
    }

    @Override
    public List<Asset> findAll() {
        return assetRepository.findAll();
    }
}
