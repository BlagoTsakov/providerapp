package com.example.providerapp.service.asset;

import com.example.providerapp.entity.Asset;
import com.example.providerapp.model.IdResponseDTO;
import com.example.providerapp.model.asset.AssetDTO;

import java.util.List;

public interface IAssetService {
    IdResponseDTO createAsset(AssetDTO assetDTO);
    List<Asset> findAll();
}
